package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfinclassdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinClassDetails.jsp", 1737911922189L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\'../js/AddModifyPatFinDetails.js\'></script> \n<script language=\"javascript\" src=\'../js/AddModifyPatFinClassDetails.js\'></script> \n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onload=\'initItems(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\",\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\", \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");defBillGroup();encDateCheck(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\");\'>\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onload=\'initItems(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\");defBillGroup();enableAllItems(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\");refreshAuthValue();\'>\n\t\t\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");defBillGroup();disableItems();\'>\n\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\");defBillGroup();disableItems();\'>\n\t\t\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onload=\'initItems(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\");defBillGroup();disableItems();\'>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\");defBillGroup();\'>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<form name=\'frmFinClsDetails\' id=\'frmFinClsDetails\'>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'3\' align=\'center\' width=\'100%\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'4\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'modify_button\' id=\'modify_button\' value=\'Modify\'  onClick=\'authUser(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");\'>\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'4\'>\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'modify_button\' id=\'modify_button\' value=\'Modify\'  onClick=\'authUser(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\'>\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<tr>\n<!--\t\t\t\t\t\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\n\t\t\t\t\t<INPUT TYPE=\"checkbox\" name=\"cash_pay_pat_YN\" id=\"cash_pay_pat_YN\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onClick=\"filter_class_type();assignValues(\'cash_pay_pat_YN\')\">\n-->\n\t\t\t\t\t<INPUT TYPE=\"HIDDEN\" name=\"cash_pay_pat_YN\" id=\"cash_pay_pat_YN\">\n<!--\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\n\t\t\t\t</td>\n-->\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<select name=\'class_type\' id=\'class_type\' onChange=\"class_type_change(this);assignValues(\'class_type\');defBillGroup();\">\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="---</option>\n\t\t\t\t\t\t<option value=\'SG\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\t\n\t\t\t\t\t\t<option value=\'PV\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\t\t\n\t\t\t\t\t\t<option value=\'IA\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</option>\n\t\t\t\t\t\t<option value=\'VS\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\t\t\n\t\t\t\t\t\t<option value=\'CR\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\t\t\t\n\t\t\t\t\t\t<option value=\'SP\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\t\t\n\t\t\t\t\t\t<option value=\'IN\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\t\t\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<option value=\'EX\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\t\n\t\t\t\t\t\t<option value=\'SC\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t<input type=\'text\' name=\'class_desc\' id=\'class_desc\' size=\'30\' maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onBlur=\"class_code_lkup(\'B\')\">\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'class_code_btn\' id=\'class_code_btn\' value=\'?\' onClick=\"class_code_lkup(\'C\')\" >\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'social_pensioner_id\' id=\'social_pensioner_id\' size=\'20\' maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" onBlur=\"assignValues(\'social_pensioner_id\')\" READONLY>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' name=\'soc_pensr_id_mand_yn\' style=\'visibility:hidden\'></img>\n\t\t\t\t</td>\n\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<select name=\'inc_asset_ind\' id=\'inc_asset_ind\' onChange = \"disableFields();defBillGroup();assignValues(\'inc_asset_ind\')\" >\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="---</option>\n\t\t\t\t\t\t<option value=\'I\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t\t\t<option value=\'A\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' name=\'inc_asset_mand_yn\' style=\'visibility:hidden\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'ind_inc\' id=\'ind_inc\' size=\'10\' maxlength=\"10\" onKeyPress=\"return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\" onBlur=\"IncomeEntry(document.forms[0].ind_inc,\'ind_inc\');\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t\t<select name=\'ind_inc_freq\' id=\'ind_inc_freq\' onChange=\"calcTotalInc();assignValues(\'ind_inc_freq\');defBillGroup()\">\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="---</option>\n\t\t\t\t\t\t<option value=\"Y\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option> \n\t\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option>\n\t\t\t\t\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'spouse_inc\' id=\'spouse_inc\' size=\'10\' maxlength=\"10\" onKeyPress=\"return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\" onBlur=\"IncomeEntry(document.forms[0].spouse_inc,\'spouse_inc\');\"  value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t<select name=\'spouse_inc_freq\' id=\'spouse_inc_freq\' onChange=\"calcTotalInc();assignValues(\'spouse_inc_freq\');defBillGroup()\">\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'dependent_inc\' id=\'dependent_inc\' size=\'10\' maxlength=\"10\" onKeyPress=\"return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\" onBlur=\"IncomeEntry(document.forms[0].dependent_inc,\'dependent_inc\');\"  value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' />\n\t\t\t\t\t<select name=\'dependent_inc_freq\' id=\'dependent_inc_freq\' onChange=\"calcTotalInc();assignValues(\'dependent_inc_freq\');defBillGroup()\">\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&nbsp;";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'tot_inc_asset\' id=\'tot_inc_asset\' size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onKeyPress=\"return ChkNumberInput(this,event,0);\" onBlur = \"assignValues(\'tot_inc_asset\');defBillGroup();\" \\>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'no_of_dependants\' id=\'no_of_dependants\' onBlur=\"assignValues(\'no_of_dependants\');chk_for_fam_incl();defBillGroup();\" size=\'2\' maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' onKeyPress=\"return ChkNumberInput(this,event,0);\">\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' name=\'no_of_dep_mand_yn\' style=\'visibility:hidden\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'blng_grp_id\' id=\'blng_grp_id\' value= \'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t\t\t<input type=\'text\' name=\'blng_grp_desc\' id=\'blng_grp_desc\' maxlength=\'40\' size=\'30\' value= \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onBlur=\"blng_grp_lkup(\'B\');\">\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'blng_grp_btn\' id=\'blng_grp_btn\' value=\'?\' onClick=\"blng_grp_lkup(\'C\');\">\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\n\t\t\t\t<input type=\'hidden\' name=\'class_type_prev\' id=\'class_type_prev\' id=\'class_type_prev\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'class_code_prev\' id=\'class_code_prev\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'class_desc_prev\' id=\'class_desc_prev\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' \\>\n\t\t\t\t<input type=\'hidden\' name=\'social_pensioner_id_prev\' id=\'social_pensioner_id_prev\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'inc_asset_ind_prev\' id=\'inc_asset_ind_prev\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'ind_inc_prev\' id=\'ind_inc_prev\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'ind_inc_freq_prev\' id=\'ind_inc_freq_prev\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'spouse_inc_prev\' id=\'spouse_inc_prev\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'spouse_inc_freq_prev\' id=\'spouse_inc_freq_prev\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'dependent_inc_prev\' id=\'dependent_inc_prev\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' \\>\t\t\n\t\t\t\t<input type=\'hidden\' name=\'dependent_inc_freq_prev\' id=\'dependent_inc_freq_prev\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' \\>\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'tot_inc_asset_prev\' id=\'tot_inc_asset_prev\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'no_of_dependants_prev\' id=\'no_of_dependants_prev\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' \\>\t\n\t\t\t\t<input type=\'hidden\' name=\'blng_grp_desc_prev\' id=\'blng_grp_desc_prev\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' \\>\n\t\t\t\t<input type=\'hidden\' name=\'blng_grp_id_prev\' id=\'blng_grp_id_prev\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' \\>\n\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'valid_from\' id=\'valid_from\' size=\'10\' maxlength=\"10\"  value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' readOnly>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'valid_to\' id=\'valid_to\' size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' onBlur=\"chkDate(document.forms[0].valid_from,this,document.forms[0].last_date);assignValues(\'tot_inc_asset\');\" readOnly>\n\t\t\t\t\t<input type=\'image\' id=\'valid_to_cal\' src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'valid_to\',document.forms[0].valid_to);assignValues(\'tot_inc_asset\')\" style=\'visibility:hidden\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' name=\'valid_to_mand_yn\' style=\'visibility:hidden\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'3\'>\n\t\t\t\t\t<input type=\'text\' name=\'remarks\' id=\'remarks\' size=\'50\' maxlength=\"40\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" onBlur = \"assignValues(\'remarks\')\">\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' name=\'remarks_mand_yn\' style=\'visibility:hidden\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t</table>\n\t\t\n\t\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' \\>\t\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' \\>\t\n\t\t\n\t\t<input type=\'hidden\' name=\'calling_module_id\' id=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' \\>\t\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' \\>\t\n\t\t<input type=\'hidden\' name=\'calling_function_id\' id=\'calling_function_id\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' \\>\n\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' \\>\n\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' \\>\n\t\t<input type=\'hidden\' name=\'class_type_selectd\' id=\'class_type_selectd\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' \\>\t\t\n\t\t<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' \\>\n\t\t<input type=\'hidden\' name=\'last_date\' id=\'last_date\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'  />\n\t\t<!--For IP -->\n\t\t<input type=\'hidden\' name=\'ipBlGrp\' id=\'ipBlGrp\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'  />\n\t\t<input type=\'hidden\' name=\'ipblng_grp_desc\' id=\'ipblng_grp_desc\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'  />\n\n\t\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'  />\n\t\t<input type=\'hidden\' name=\'childMinAge\' id=\'childMinAge\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'  />\n\t\t<input type=\'hidden\' name=\'max_days_for_prov_class\' id=\'max_days_for_prov_class\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'  />\n\t\t\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'  />\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'  />\n\t\t<input type=\'hidden\' name=\'upd_class_dtls_YN\' id=\'upd_class_dtls_YN\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'  />\t\t\n\t\t<input type=\'hidden\' name=\'blng_grp_changed_YN\' id=\'blng_grp_changed_YN\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'  />\t\t\n\t\t<input type=\'hidden\' name=\'valid_to_for_prov_class\' id=\'valid_to_for_prov_class\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'  />\t\t\t\t\n\t\t<input type=\'hidden\' name=\'fam_mem_incl_YN\' id=\'fam_mem_incl_YN\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'  />\t\t\t\t\t\t\n\n\t\t<input type=\'hidden\' name=\'fin_class_dtls_updated_YN\' id=\'fin_class_dtls_updated_YN\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'  />\t\n\t\t<input type=\'hidden\' name=\'class_code_valid_YN\' id=\'class_code_valid_YN\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'  />\t\n\t\t\n\t\t<input type=\'hidden\' name=\'encounter_date_aft_trunc\' id=\'encounter_date_aft_trunc\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'  />\t\n\t\t<input type=\'hidden\' name=\'isUsedAuthorized\' id=\'isUsedAuthorized\' value=\'N\'>\n\t\t<input type=\'hidden\' name =\'incld_dep_inc_yn\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name =\'siteSpec\' id =\'siteSpec\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t\t<input type=\'hidden\' name =\'blng_grp_id_temp\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t<input type=\'hidden\' name=\'blGrpIdMPI\' id=\'blGrpIdMPI\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'classTypChangeAuthYnPatId\' id=\'classTypChangeAuthYnPatId\' id=\'classTypChangeAuthYnPatId\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t\t<input type=\'hidden\' name=\'tabsSwapped\' id=\'tabsSwapped\' value=\'N\'>\n\t\t\n\t\t\n\t\t<input type=\'hidden\' name=\'classTypChangeAuthYN\' id=\'classTypChangeAuthYN\'  id=\'classTypChangeAuthYN\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t<input type=\'hidden\' name=\'changePatAuthYN\' id=\'changePatAuthYN\' id=\'changePatAuthYN\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'prevPatId\' id=\'prevPatId\'  id=\'prevPatId\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t\t<input type=\'hidden\' name=\'sessionClinicCode\' id=\'sessionClinicCode\'  id=\'sessionClinicCode\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t<input type=\'hidden\' name=\'reqClinicCode\' id=\'reqClinicCode\'  id=\'reqClinicCode\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t<input type=\'hidden\' name=\'boolSecurity\' id=\'boolSecurity\'  id=\'boolSecurity\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'> <!-- Added by Subha/GDOH-SCF-0289/V19072018  -->\n\t\t\n\t\t\n\t\t\n\t\t\n\t</form>\n</body>\n\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n</html>\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	Connection con = ConnectionManager.getConnection();	
	try
	{
		PreparedStatement pstmt = null;
		Statement stmt				= null;
		ResultSet rs = null;

		HttpSession httpSession = request.getSession(false);
		String locale			= (String)session.getAttribute("LOCALE");
		String delimiter="::";
		String prevPatId="";
		String classTypChangeAuthYN="";
		String changePatAuthYN="";
		
		String classTypChangeAuthYnPatId			= (String)session.getAttribute("classTypChangeAuthYnPatId");
		changePatAuthYN			= (String)session.getAttribute("changePatAuthYN");
		System.err.println("classTypChangeAuthYnPatId "+classTypChangeAuthYnPatId);
		//System.err.println(" bef loop prevPatId "+prevPatId);
		// System.err.println("bef loop classTypChangeAuthYN :: "+classTypChangeAuthYN);
		String sessionClinicCode = (String)session.getAttribute("str_clinic_code");
		if(sessionClinicCode == null) sessionClinicCode="";
		String reqClinicCode = request.getParameter("clinic_code");	
		if(reqClinicCode == null) reqClinicCode="";
		
		System.err.println(" sessionClinicCode:: "+sessionClinicCode+" reqClinicCode :: "+reqClinicCode);
		 
		if(classTypChangeAuthYnPatId != null){
			
			System.err.println("In loop classTypChangeAuthYnPatId "+classTypChangeAuthYnPatId);
			 String[] classTypChangeTokens=classTypChangeAuthYnPatId.split(delimiter);
			 //System.out.println("classTypChangeTokens "+classTypChangeTokens);
			 prevPatId=classTypChangeTokens[0];
			 System.err.println("prevPatId "+prevPatId);
			 classTypChangeAuthYN=classTypChangeTokens[1];
			 System.err.println("classTypChangeAuthYN :: "+classTypChangeAuthYN);
		}
		
		 System.err.println("prevPatId "+prevPatId+"/ classTypChangeAuthYN :: "+classTypChangeAuthYN);

		System.err.println("AddModifyPatFinClassDtls.jsp classTypChangeAuthYN :: "+classTypChangeAuthYN+"/ prevPatId :: "+prevPatId+" /classTypChangeAuthYN :: "+classTypChangeAuthYN);

		String slmt_ind = "", cash_patient_YN="", class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
		String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "";
		String dependent_inc_freq = "", tot_inc_asset = "", no_of_dependants = "", blng_grp_id = "", blng_grp_desc = "";
		String valid_from = "", valid_to = "", last_date = "", age = "", childMinAge = "";
		int max_days_for_prov_class = 0;
		String valid_to_for_prov_class="";
		String ipBlGrp = "",ipblng_grp_desc="";
		String incld_dep_inc_yn = "Y";
		String sql = "";
		String sysDate = "";
		String strEpisodeType = "", upd_class_dtls_YN="N", blng_grp_changed_YN="N", fin_class_dtls_updated_YN="N";
		int assessmentMonths = 0, noofdecimal=2;
		String encounter_date_time = "", encounter_date_aft_trunc="", sys_date_wht_sec="";
		String fam_mem_incl_YN="N", class_code_valid_YN="N";
		boolean boolPatientFoundMP = false;
		boolean boolSecurity = false;	
		String classStartDate="",classEndDate="",blGrpIdMPI="";
		String blng_grp_id_temp="";
		
		String strAllParam	= request.getQueryString();

		String strModuleId =  request.getParameter("calling_module_id") ==null ? "" : request.getParameter("calling_module_id");	

		String functionId =  request.getParameter("calling_function_id") == null? "" :request.getParameter("calling_function_id");

		String facilityId =  (String)httpSession.getValue("facility_id");
		if(facilityId == null) facilityId="";

		String billing_mode =  request.getParameter("billing_mode") == null? "" :request.getParameter("billing_mode");
		String operation =  request.getParameter("operation") == null? "" :request.getParameter("operation");

		String sex = request.getParameter("sex") == null? "" :request.getParameter("sex");

//		String clinicCode = request.getParameter("clinic_code") == null? "" :request.getParameter("clinic_code");

		String patientId = request.getParameter("patient_id") == null? "" :request.getParameter("patient_id");

		String fin_dtl_call = request.getParameter("fin_dtl_call") == null? "N" :request.getParameter("fin_dtl_call");

		upd_class_dtls_YN = request.getParameter("upd_class_dtls_YN") == null? "N" :request.getParameter("upd_class_dtls_YN");
/*
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date_wht_sec = rs.getString(1);
					sysDate = rs.getString(2); 
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sys_date_wht_sec"+e);
		}
		
		
*/
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from  sm_acc_entity_param where acc_entity_id='ZZ'");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
				sys_date_wht_sec = rscurr.getString(2);
				sysDate = rscurr.getString(3);
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}

		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";

		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

		try
		{
			String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_trunc_time) ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}


//		if((!strModuleId.equals("IP") || billing_mode.equals("Add")) && (!functionId.equals("CHG_PAT_DTLS")))
		if(fin_dtl_call.equals("Y"))
		{
			slmt_ind = request.getParameter("slmt_ind") == null? "" :request.getParameter("slmt_ind");

			class_type = request.getParameter("class_type") == null? "" :request.getParameter("class_type");
			
			class_code = request.getParameter("class_code") == null? "" :request.getParameter("class_code");
			
			remarks = request.getParameter("remarks") == null? "" :request.getParameter("remarks");
			
			social_pensioner_id = request.getParameter("social_pensioner_id") == null? "" : request.getParameter("social_pensioner_id");
			
			inc_asset_ind = request.getParameter("inc_asset_ind") == null? "" : request.getParameter("inc_asset_ind");
			
			ind_inc = request.getParameter("ind_inc") == null? "0" :request.getParameter("ind_inc");
			
			ind_inc_freq = request.getParameter("ind_inc_freq") == null? "" :request.getParameter("ind_inc_freq");
			
			spouse_inc = request.getParameter("spouse_inc") == null? "0" :request.getParameter("spouse_inc");
			
			spouse_inc_freq = request.getParameter("spouse_inc_freq") == null? "" :request.getParameter("spouse_inc_freq");
			
			dependent_inc = request.getParameter("dependent_inc") == null? "0" :request.getParameter("dependent_inc");
			
			dependent_inc_freq = request.getParameter("dependent_inc_freq") == null? "" :request.getParameter("dependent_inc_freq");
			
			tot_inc_asset = request.getParameter("tot_inc_asset") == null? "" :request.getParameter("tot_inc_asset");
			
			no_of_dependants = request.getParameter("no_of_dependants") == null? "" :request.getParameter("no_of_dependants");
			
			blng_grp_id = request.getParameter("blng_grp_id") == null? "" :request.getParameter("blng_grp_id");

			valid_from = request.getParameter("valid_from") == null? "" :request.getParameter("valid_from");
			
			valid_to = request.getParameter("valid_to") == null? "" :request.getParameter("valid_to");
			
			last_date = request.getParameter("last_date")== null ? "" : request.getParameter("last_date");
		}
		System.err.println("initial :: class_type / inc_asset_ind / ind_inc / ind_inc_freq / blng_grp_id"+class_type+"/"+inc_asset_ind+"/"+ind_inc+"/"+ind_inc_freq+"/"+blng_grp_id+" fin_dtl_call::: "+fin_dtl_call);
	
		Boolean siteSpec=false;
		Boolean Site_spec=false;
		try
		{
			
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}
		
		
		String SiteSpecific ="";
			try
			{
				con = ConnectionManager.getConnection();	
				Site_spec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in site specific "+e);
			}
			if(Site_spec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}

String finDetClose="";
//		if((functionId.equals("CHG_PAT_DTLS") || functionId.equals("PAT_REG")) && (billing_mode.equals("Modify")))
		if((billing_mode.equals("Modify") || operation.equals("Update")) && fin_dtl_call.equals("N"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");

			if(!(bl_data==null || bl_data.isEmpty()))
			{
				finDetClose = ((String)bl_data.get("fin_det_close")).trim();
				if(finDetClose == null) finDetClose="";
				
				System.out.println("finDetClose BEF:::"+finDetClose);
				if(siteSpec)
				{
				if(strModuleId.equals("IP") || strModuleId.equals("DC")) {
					 
					if(finDetClose.equals("Y")){		
							
						 	System.out.println("finDetClose :::"+finDetClose);
							blng_grp_id=((String)bl_data.get("blng_grp")).trim();
							if(blng_grp_id == null) blng_grp_id="";
							slmt_ind=((String)bl_data.get("slmt_ind")).trim();
							if(slmt_ind == null) slmt_ind="";
							class_type=((String)bl_data.get("class_type")).trim();
							if(class_type == null) class_type="";
							class_code=((String)bl_data.get("class_code")).trim();
							if(class_code == null) class_code="";
							remarks=((String)bl_data.get("fin_remarks")).trim();
							if(remarks == null) remarks="";
							inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
							if(inc_asset_ind == null) inc_asset_ind="";
							ind_inc=((String)bl_data.get("ind_inc")).trim();
							if(ind_inc == null) ind_inc="0";
							ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
							if(ind_inc_freq == null) ind_inc_freq="";
							spouse_inc=((String)bl_data.get("spouse_inc")).trim();
							if(spouse_inc == null) spouse_inc="0";
							spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
							if(spouse_inc_freq == null) spouse_inc_freq="";
							dependent_inc=((String)bl_data.get("dependent_inc")).trim();
							if(dependent_inc == null) dependent_inc="0";
							dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
							if(dependent_inc_freq == null) dependent_inc_freq="";
							no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
							if(no_of_dependants == null) no_of_dependants="";
							valid_from=((String)bl_data.get("valid_from")).trim();
							if(valid_from == null) valid_from="";							
							valid_to=((String)bl_data.get("valid_to")).trim();
							if(valid_to == null) valid_to="";
							last_date=((String)bl_data.get("last_date")).trim();
							if(last_date == null) last_date="";

							if(inc_asset_ind.equals("I"))
							{
								tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
								if(tot_inc_asset == null) tot_inc_asset=""; 
							}
							else if(inc_asset_ind.equals("A"))
							{
								tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
								if(tot_inc_asset == null) tot_inc_asset=""; 
							}
							social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
							if(social_pensioner_id == null) social_pensioner_id="";
						}else{
							valid_from=((String)bl_data.get("valid_from")).trim();
							if(valid_from == null) valid_from="";	

							valid_to=((String)bl_data.get("valid_to")).trim();
							if(valid_to == null) valid_to="";
							
							last_date=((String)bl_data.get("last_date")).trim();
							if(last_date == null) last_date="";
							
							blng_grp_id_temp=((String)bl_data.get("blng_grp")).trim();
							if(blng_grp_id_temp == null) blng_grp_id_temp="";
							
						
						}
	 }else{


			System.out.println("finDetClose :::"+finDetClose);
			blng_grp_id=((String)bl_data.get("blng_grp")).trim();
				if(blng_grp_id == null) blng_grp_id="";
				slmt_ind=((String)bl_data.get("slmt_ind")).trim();
				if(slmt_ind == null) slmt_ind="";
				class_type=((String)bl_data.get("class_type")).trim();
				if(class_type == null) class_type="";
				class_code=((String)bl_data.get("class_code")).trim();
				if(class_code == null) class_code="";
				remarks=((String)bl_data.get("fin_remarks")).trim();
				if(remarks == null) remarks="";
				inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
				if(inc_asset_ind == null) inc_asset_ind="";
				ind_inc=((String)bl_data.get("ind_inc")).trim();
				if(ind_inc == null) ind_inc="0";
				ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
				if(ind_inc_freq == null) ind_inc_freq="";
				spouse_inc=((String)bl_data.get("spouse_inc")).trim();
				if(spouse_inc == null) spouse_inc="0";
				spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
				if(spouse_inc_freq == null) spouse_inc_freq="";
				dependent_inc=((String)bl_data.get("dependent_inc")).trim();
				if(dependent_inc == null) dependent_inc="0";
				dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
				if(dependent_inc_freq == null) dependent_inc_freq="";
				no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
				if(no_of_dependants == null) no_of_dependants="";
				valid_from=((String)bl_data.get("valid_from")).trim();
				if(valid_from == null) valid_from="";	
				/*	if(strModuleId.equals("MP"))
				{
				valid_from=encounter_date_aft_trunc;
					if(valid_from == null) valid_from="";
				}*/


				valid_to=((String)bl_data.get("valid_to")).trim();
				if(valid_to == null) valid_to="";
				last_date=((String)bl_data.get("last_date")).trim();
				if(last_date == null) last_date="";

				if(inc_asset_ind.equals("I"))
				{
					tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
					if(tot_inc_asset == null) tot_inc_asset=""; 
				}
				else if(inc_asset_ind.equals("A"))
				{
					tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
					if(tot_inc_asset == null) tot_inc_asset=""; 
				}
				social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
				if(social_pensioner_id == null) social_pensioner_id="";
					
	 }
				
	}
	else{

		System.out.println("finDetClose :::"+finDetClose);
		blng_grp_id=((String)bl_data.get("blng_grp")).trim();
		if(blng_grp_id == null) blng_grp_id="";
		slmt_ind=((String)bl_data.get("slmt_ind")).trim();
		if(slmt_ind == null) slmt_ind="";
		class_type=((String)bl_data.get("class_type")).trim();
		if(class_type == null) class_type="";
		class_code=((String)bl_data.get("class_code")).trim();
		if(class_code == null) class_code="";
		remarks=((String)bl_data.get("fin_remarks")).trim();
		if(remarks == null) remarks="";
		inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
		if(inc_asset_ind == null) inc_asset_ind="";
		ind_inc=((String)bl_data.get("ind_inc")).trim();
		if(ind_inc == null) ind_inc="0";
		ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
		if(ind_inc_freq == null) ind_inc_freq="";
		spouse_inc=((String)bl_data.get("spouse_inc")).trim();
		if(spouse_inc == null) spouse_inc="0";
		spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
		if(spouse_inc_freq == null) spouse_inc_freq="";
		dependent_inc=((String)bl_data.get("dependent_inc")).trim();
		if(dependent_inc == null) dependent_inc="0";
		dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
		if(dependent_inc_freq == null) dependent_inc_freq="";
		no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
		if(no_of_dependants == null) no_of_dependants="";
		valid_from=((String)bl_data.get("valid_from")).trim();
		if(valid_from == null) valid_from="";	
		/*	if(strModuleId.equals("MP"))
		{
		valid_from=encounter_date_aft_trunc;
			if(valid_from == null) valid_from="";
		}*/


		valid_to=((String)bl_data.get("valid_to")).trim();
		if(valid_to == null) valid_to="";
		last_date=((String)bl_data.get("last_date")).trim();
		if(last_date == null) last_date="";

		if(inc_asset_ind.equals("I"))
		{
			tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
			if(tot_inc_asset == null) tot_inc_asset=""; 
		}
		else if(inc_asset_ind.equals("A"))
		{
			tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
			if(tot_inc_asset == null) tot_inc_asset=""; 
		}
		social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
		if(social_pensioner_id == null) social_pensioner_id="";
		
				}
			}
		}
		System.out.println("next :: class_type / inc_asset_ind / ind_inc / ind_inc_freq / blng_grp_id"+class_type+"/"+inc_asset_ind+"/"+ind_inc+"/"+ind_inc_freq+"/"+blng_grp_id);

		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				fin_class_dtls_updated_YN=((String)bl_data.get("fin_class_dtls_updated_YN"));
				if(fin_class_dtls_updated_YN == null) fin_class_dtls_updated_YN="N";
				fin_class_dtls_updated_YN = fin_class_dtls_updated_YN.trim();
			}
		}
		
		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			sql = "SELECT SHORT_DESC CLASSIFICATION_DESC,NVL(INCL_FAMILY_YN,'N') INCL_FAMILY_YN FROM BL_CLASSFCTN_CODE_LANG_VW WHERE CLASSIFICATION_CODE = ? AND LANGUAGE_ID = ?";
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,class_code);
				pstmt.setString(2,locale);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					class_desc = rs.getString("CLASSIFICATION_DESC");
					fam_mem_incl_YN = rs.getString("INCL_FAMILY_YN");
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception from CLASSIFICATION_DESC:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
			if(class_desc == null) class_desc="";
			if(fam_mem_incl_YN == null) fam_mem_incl_YN="N";


			sql = "SELECT SHORT_DESC BILLING_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID=? AND LANGUAGE_ID = ?";
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,blng_grp_id);
				pstmt.setString(2,locale);
				rs = pstmt.executeQuery();
				if(rs.next())
					blng_grp_desc = rs.getString("BILLING_DESC");
			}
			catch(Exception e)
			{
				System.err.println("Exception from BILLING_DESC:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
			if(blng_grp_desc == null) blng_grp_desc="";

		}

		
		if(siteSpec){
		sql = "SELECT to_char(CLASSIFICATION_START_DATE,'dd/mm/yyyy') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'dd/mm/yyyy') CLASSIFICATION_END_DATE,BLNG_GRP_ID FROM BL_PATIENT_FIN_DTLS WHERE PATIENT_ID=?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patientId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				classStartDate = rs.getString(1);		
		    	classEndDate = rs.getString(2);
		    	blGrpIdMPI=rs.getString(3);
		    	System.out.println("classStartDate::classEndDate::blGrpIdMPI "+classStartDate+"::"+classEndDate+"::"+blGrpIdMPI);
		    	
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception from ASSESSMENT_MONTHS:"+e );
		}
		finally
		{
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		}
		
		if(classStartDate==null) classStartDate="";
		if(classEndDate==null) classEndDate="";
		valid_from=classStartDate;
		valid_to=classEndDate;
		}
		
		/*Getting ASSESSMENT_MONTHS, valid from & to dates, last date */ 
		if((valid_from.equals("") && valid_to.equals(""))||(fin_class_dtls_updated_YN.equals("N")&& strModuleId.equals("MP")))
		{
			sql = "SELECT ASSESSMENT_MONTHS FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID =?";
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facilityId);
				rs = pstmt.executeQuery();
				if(rs.next())
					assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
			}
			catch(Exception e)
			{
				System.err.println("Exception from ASSESSMENT_MONTHS:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
//			System.err.println("assessmentMonths:"+assessmentMonths);

			valid_from = encounter_date_aft_trunc;

			sql = "SELECT to_char(add_months(to_date('"+valid_from+"','DD/MM/YYYY'),"+assessmentMonths+"),'dd/mm/yyyy') LAST_DATE FROM DUAL";

			try
			{
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					last_date = rs.getString("LAST_DATE");
				}
			}
			catch(Exception e)
			{
				System.err.println("Error getting sysdate and last_date :"+e);
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}

		} 

		//Getting the billing details if its already entered

		if(!strModuleId.equals("MP"))
		{	
			sql="select floor((to_date('"+valid_from+"','DD/MM/YYYY')-date_of_birth)/365) age, SEX  from mp_patient where patient_id =?";

			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patientId);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					age = rs.getString(1);
					sex = rs.getString(2);
				}


			}
			catch(Exception e)
			{
				System.err.println("Exception from getting age:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	

			sql="SELECT nvl(CHILD_AGE_UPTO_IN_YEARS,0) CHILD_MIN_AGE from bl_parameters where operating_facility_id  = ?";
			//System.err.println("sql:"+sql);
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facilityId);
				rs = pstmt.executeQuery();
				if(rs.next())
				childMinAge = rs.getString("CHILD_MIN_AGE");
//				System.err.println("childMinAge :"+childMinAge);
			}
			catch(Exception e)
			{
				System.err.println("Exception from getting CHILD_MIN_AGE:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	
	
//			String err = "";
			try
			{
/*
				String Query_BL_GET_RECLASS_DETAILS = "{ call BL_GET_RECLASS_DETAILS('"+facilityId+"','"+patientId+"','"+strEpisodeType+"','"+clinicCode+"',to_date('"+sysDate+"','DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?) }";

				CallableStatement call = con.prepareCall(Query_BL_GET_RECLASS_DETAILS);		
				
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.registerOutParameter(2,java.sql.Types.VARCHAR);
				call.registerOutParameter(3,java.sql.Types.INTEGER);
				call.registerOutParameter(4,java.sql.Types.VARCHAR);
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);	
				call.registerOutParameter(8,java.sql.Types.VARCHAR);	
				call.registerOutParameter(9,java.sql.Types.VARCHAR);	
				call.registerOutParameter(10,java.sql.Types.VARCHAR);	
				call.registerOutParameter(11,java.sql.Types.VARCHAR);	
				call.execute();
			 
				ipBlGrp = call.getString(1) == null ? "" : call.getString(1);
//				ipblng_grp_desc = call.getString(10) == null ? "" : call.getString(10);
				err = call.getString(11)== null ? "" : call.getString(11);

				System.err.println("ipBlGrp:"+ipBlGrp);
				System.err.println("ipblng_grp_desc:"+ipblng_grp_desc);
				System.err.println("err:"+err);
				call.close();
*/
			}
			catch(Exception e)
			{
				System.err.println("Exception from procedure BL_GET_RECLASS_DETAILS :"+e);
			}

			sql="select 'Y' from BL_CLASSFCTN_CODE where CLASSIFICATION_CODE='"+class_code+"' AND CLASSIFICATION_TYPE='"+class_type+"' AND OPERATING_FACILITY_ID='"+facilityId+"' AND decode('"+strEpisodeType+"','R',VALID_FOR_BASIC_CLSFCTN,'O',VALID_FOR_BASIC_OP,'E',VALID_FOR_BASIC_EM,'I',VALID_FOR_BASIC_IP,'D',VALID_FOR_BASIC_DY)='Y' AND appl_patient_sex in('"+sex+"','B') AND ((APPL_TO_CHILD='Y') OR (APPL_TO_CHILD='N' AND '"+age+"' >= "+childMinAge+"))";
//			System.err.println("Valid Class for Encoutner YN query:"+sql);
			try
			{
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();
				if(rs.next())
				{
					class_code_valid_YN = rs.getString(1);
				}
				else
				{
					class_code_valid_YN = "N";
				}
				System.err.println("class_code_valid_YN:"+class_code_valid_YN);
			}
			catch(Exception e)
			{
				System.err.println("Exception from getting age:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	
		}
		if(!patientId.equals(""))
		{
			try
			{
				String sqlCiti = "select a.citizen_yn,to_char(a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, b.gl_holder_name gl_holder_name, b.pat_reln_with_gl_holder pat_reln_with_gl_holder from mp_patient a, bl_patient_fin_dtls b where a.patient_id ='"+patientId+"' and a.patient_id=b.patient_id";
				pstmt = con.prepareStatement(sqlCiti);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
					while( rs.next() )
					{  
						boolPatientFoundMP = true;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception in sqlCiti:"+e);
			}
			finally
			{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}	
		}
		
		if (((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) || ((strModuleId.equals("IP") || strModuleId.equals("DC") ||           strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true)))
		{
			boolSecurity = true;
		}
		if(valid_to.equals(""))
			valid_to = 	last_date;

		try
		{
			sql = "SELECT MAX_DAYS_ALLWD_PROV_CLSFCTN,to_char(to_date('"+encounter_date_aft_trunc+"','DD/MM/YYYY')+(MAX_DAYS_ALLWD_PROV_CLSFCTN-1),'DD/MM/YYYY'),NVL(INCLUDE_DEP_INC_TOTAL_YN,'N')  FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID =?";

//			System.err.println("sql:"+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				max_days_for_prov_class = rs.getInt(1);
				valid_to_for_prov_class = rs.getString(2);
				incld_dep_inc_yn	=rs.getString(3);
			}
			
			if (pstmt!=null) pstmt.close();
			if (rs!=null)	 rs.close();
//			System.err.println("max_days_for_prov_class:"+max_days_for_prov_class);
//			System.err.println("valid_to_for_prov_class:"+valid_to_for_prov_class);
		}
		catch(Exception e)
		{
			System.err.println("Exception while fetching max_days_for_prov_class:"+e);
		}

		if(!locale.equals("en"))
		{
			if(!valid_from.equals(""))
			{
				valid_from = com.ehis.util.DateUtils.convertDate(valid_from,"DMY","en",locale);
			}

			if(!valid_to.equals(""))
			{
				valid_to = com.ehis.util.DateUtils.convertDate(valid_to,"DMY","en",locale);
			}

			if(!last_date.equals(""))
			{
				last_date = com.ehis.util.DateUtils.convertDate(last_date,"DMY","en",locale);
			}
			
		}

		CurrencyFormat cf = new CurrencyFormat();

		ind_inc = cf.formatCurrency(ind_inc, noofdecimal);
		spouse_inc = cf.formatCurrency(spouse_inc, noofdecimal);
		dependent_inc = cf.formatCurrency(dependent_inc, noofdecimal);
System.out.println("strModuleId / functionId / siteSpec :: "+strModuleId+"/"+functionId+"/"+siteSpec);
		if(!functionId.equals("PAT_REG"))
		{
		  if(siteSpec){
			  
			if(((strModuleId.equals("IP") || strModuleId.equals("DC")) && functionId.equals("ADMISSION"))){
				System.out.println("1111111111111 test"); 
			 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			else if(strModuleId.equals("OP") || strModuleId.equals("AE")){
				System.out.println("2222222222 test"); 
				 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block14Bytes, _wl_block14);


			 }
			else{
				System.out.println("3333333333 test"); 
				 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block15Bytes, _wl_block15);


			 }
			
		  }
		 else{
			 System.out.println("4444444444444 test"); 
			 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block16Bytes, _wl_block16);


		 }
		}
		else
		{
			 System.out.println("5555555555 test"); 
			if( operation.equals("Update") && (boolSecurity == true) && (strModuleId.equals("MP")) && (SiteSpecific.equals("Y"))){

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
			else{
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
		}

            _bw.write(_wl_block20Bytes, _wl_block20);

		if(!functionId.equals("PAT_REG"))
		{
		  if(siteSpec){
			 if( !(strModuleId.equals("IP") || strModuleId.equals("DC")|| strModuleId.equals("OP") || strModuleId.equals("AE")))
			 {

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block22Bytes, _wl_block22);

			 }

		  }
		  else{
			  
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block24Bytes, _wl_block24);


		  }
		}
		
		if(slmt_ind.equals("C"))
		{
			cash_patient_YN = "CHECKED";
		}
		else
		{
			cash_patient_YN = "";
		}

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cash_patient_YN));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
 
		if(!strEpisodeType.equals("R"))
		{

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

		}

            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(class_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(social_pensioner_id));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ind_inc));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(spouse_inc));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dependent_inc));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tot_inc_asset));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(class_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(social_pensioner_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(ind_inc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(spouse_inc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dependent_inc));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(tot_inc_asset));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block86Bytes, _wl_block86);

		if(strEpisodeType.equals("R"))
		{

            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block89Bytes, _wl_block89);

		}

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(ipBlGrp));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(ipblng_grp_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(age));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(childMinAge));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(max_days_for_prov_class));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(upd_class_dtls_YN));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(blng_grp_changed_YN));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(valid_to_for_prov_class));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(fam_mem_incl_YN));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(fin_class_dtls_updated_YN));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(class_code_valid_YN));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(incld_dep_inc_yn));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(siteSpec));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(blng_grp_id_temp));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(blGrpIdMPI));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classTypChangeAuthYnPatId));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classTypChangeAuthYN));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(changePatAuthYN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prevPatId));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(sessionClinicCode));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(reqClinicCode));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(boolSecurity));
            _bw.write(_wl_block125Bytes, _wl_block125);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Main Exception:"+e);
		out.println(e);
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block126Bytes, _wl_block126);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_PAY_PAT.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CLASS_TYPE.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SOCIAL_GRANT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Provisional.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCOME_ASSET_BASED.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visitor.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SPONSORED.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Insurance.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EXEMPTED.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SPECIAL_CASE.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CLASS_CODE.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SOCIAL_PENSIONER_ID.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCOME_ASSET_BASED.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCOME.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ASSET.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INDVL_INC_FREQ.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Yearly.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.monthly.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weekly.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SPOUSE_INC_FREQ.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Yearly.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.monthly.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weekly.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DEP_INC_FREQ.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Yearly.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.monthly.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weekly.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCOME_ASSET.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NO_OF_DEPENDANTS.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VALID_FROM.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VALID_TO.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FINANCIAL_REMARKS.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
