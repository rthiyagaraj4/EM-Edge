package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import eXH.InterfaceUtil;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetailsmultiblnggrpbody_sep20 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsMultiBlngGrpBody_Sep20.jsp", 1744006312913L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<STYLE TYPE=\"text/CSS\">\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#tbl-container {\nwidth: 955px;\nheight: 390px;\noverflow: auto;\n}\n\nthead td, thead td.locked\t{\nposition:relative;\n}\n\nthead td {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \nz-index: 20;\n}\n\n</STYLE>\n<script>\n\n\nfunction selected(i)\n{\n\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\n\n\tif(selected_row.checked==false)\n\t{\n\t\tselected_row.checked=false;\n\t\tdocument.forms[0].checked_row.value=\"\";\n\t}\n\telse\n\t{\n\t\tvar total_records=document.forms[0].total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"document.forms[0].selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\t\tselected_row.checked=true;\n\t\tdocument.forms[0].checked_row.value=i;\n\t}\n}\n\nfunction check(i)\n{\n\t\tdocument.forms[0].focussed_row.value=i;\n}\n\nfunction policy_coverage_basis_ind()\n{\n\tvar totalRecords=document.forms[0].total_records.value;\n\n\tif(totalRecords!=0)\n\t{\n\t\tfor(var i=0;i<totalRecords;i++)\n\t\t{\n\t\t\tvar policy_cov_basis_ind=document.getElementById(\"policy_coverage_basis_\"+i);\n\t\t\tvar policy_cov_basis_ind_val=eval(\"document.forms[0].policy_coverage_basis_ind\"+i);\n\t\t\tif(policy_cov_basis_ind_val.value==\"P\")\n\t\t\t{\n\t\t\t\tpolicy_cov_basis_ind.innerText=getLabel(\"eBL.PATIENT_BASED.label\",\"BL\");\n\t\t\t}\n\t\t\telse if(policy_cov_basis_ind_val.value==\"I\")\n\t\t\t{\n\t\t\t\tpolicy_cov_basis_ind.innerText=getLabel(\"eBL.PAYER_BASED.label\",\"BL\");\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction dflt_pol_validity_date()\n{\n\tvar locale=document.forms[0].locale.value;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\tvar total_records= document.forms[0].total_records.value;\n\n\tif(module_id != \'MP\')\n\t{\n\t\tfor(var i=0;i<total_records;i++)\n\t\t{\n\t\t\tvar policy_eff_frm_date = eval(\"document.forms[0].policy_eff_frm_date\"+i);\n\t\t\tvar credit_apprd_days = eval(\"document.forms[0].credit_apprd_days\"+i);\n\t\t\tvar apprd_days_restrict_check = eval(\"document.forms[0].apprd_days_restrict_check\"+i);\n\t\t\tvar pol_validity_chk_date = eval(\"document.forms[0].pol_validity_chk_date\"+i);\n\n\t\t\tif(policy_eff_frm_date.value != \"\" && credit_apprd_days.value != \"\" && apprd_days_restrict_check.value==\'R\')\n\t\t\t{\n\t\t\t\tvar pol_validity_chk_date_val = plusDate(policy_eff_frm_date.value,\'DMY\',locale,eval(credit_apprd_days.value)-1,\'d\');\n\n\t\t\t\tpol_validity_chk_date.value=pol_validity_chk_date_val;\n\t\t\t}\n\t\t}\n\t}\n}\n</script>\n\n</head>\n\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"policy_coverage_basis_ind();dflt_pol_validity_date();\">\n\n<form name=\'\' id=\'\' method=\'post\' >\n<!--\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\'  border=1 id=\'ins_data\'>\n-->\n<div id=\'tbl-container\'>\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\'  border=1 id=\'ins_data\'>\n<thead>\n<tr><td class=\'COLUMNHEADER\' colspan=\'9\' align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td></tr>\n<tr>\n\t<td class=\'COLUMNHEADER\' width=\'14%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'11%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t</tr>\n</thead>\n<tbody>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<tr id=row";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n<input type=hidden name=\'billing_group_desc";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'billing_group_desc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=hidden name=\'blng_grp_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'blng_grp_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\n<td class=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" width=\'14%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'selected_row";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onClick=\"selected(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\">&nbsp;&nbsp;<input maxlength=\'15\' size=\'12\' type=text name=\'ins_cust_group_name";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'ins_cust_group_name";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onFocus=\'check(";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =");\'  readonly></td>\n\n<td class=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" width=\'12%\' ><input maxlength=\'15\' size=\'13\' type=text name=\'payer_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'payer_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  readonly></td><input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'cust_3";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<!--\n<input type=\'hidden\' name=\'ins_cust_group_name";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n-->\n<input type=\'hidden\' name=\'ins_cust_group_code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'ins_cust_group_code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"><input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'valid_payer_YN";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'cust_valid_from_date";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'cust_valid_to_date";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'payer_suspended_YN";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" width=\'7%\'><input type=\"text\" maxlength=\'2\' size=\"3\" name=\'priority";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'priority";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' style=\'text-align:right\'  value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'  readonly></td> \n\n<td class=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" width=\'12%\' ><input maxlength=\'15\' size=\'13\' type=text name=\'policy_type_desc";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'policy_type_desc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"  readonly></td><input type=\'hidden\' name=\'policy_type_code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'policy_type_code";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" ><input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'policy_suspended_YN";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" width=\'12%\'><input type=\"text\" maxlength=\'30\' size=\"13\" name=\'policy_no";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'policy_no";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'   value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"  readonly></td>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n<td class=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" width=\'10%\' ><input type=\'text\'  name=\'policy_start_date";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'policy_start_date";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'  readonly></td>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" width=\'10%\'><input type=\'text\'  name=\'policy_exp_date";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'policy_exp_date";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'   readonly></td>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" width=\'12%\'><div id=\"credit_auth_val_disp";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" style=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" ><input type=\"text\" maxlength=\'20\' size=\"13\" name=\'credit_auth_ref";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'credit_auth_ref";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"  readonly></div></td>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" width=\'11%\'><div id=\"credit_auth_date_val_disp";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" ><input type=\'text\'  name=\'credit_auth_date";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'credit_auth_date";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' readonly></div></td>\n\n</tr>\n\n<tr id=row";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n<td class=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" width=\'14%\'><b id=\"policy_coverage_basis_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"></b></td>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\n<td class=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" width=\'12%\' ><div id=\"apprd_amt_leg_disp";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</div></td>\n<td class=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" width=\'7%\'><div id=\"apprd_amt_val_disp";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" ><input type=\"text\" maxlength=\'10\' size=\"7\" name=\'credit_apprd_amt";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'credit_apprd_amt";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'  readonly></div></td>\n\n<td  class=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" width=\'12%\'  ><div id=\"apprd_days_leg_disp";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" width=\'12%\'><div id=\"apprd_days_val_disp";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" ><input type=\"text\" maxlength=\'4\' size=\"4\" name=\'credit_apprd_days";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' id=\'credit_apprd_days";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'  readonly></div></td>\n\t\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" width=\'10%\' >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n<td class=";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" width=\'10%\'><input type=\'text\'  name=\'policy_eff_frm_date";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'policy_eff_frm_date";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' readonly></td>\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" width=\'12%\' >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" width=\'11%\'><input type=\'text\'  name=\'policy_eff_to_date";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'policy_eff_to_date";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' readonly></td>\n</tr>\n\n<input type=\'hidden\' name=\'adj_rule_ind";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' id=\'adj_rule_ind";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\'hidden\' name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' id=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<input type=\'hidden\' name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' id=\'adj_perc_amt_value";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<input type=\'hidden\' name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<input type=\'hidden\' name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n<input type=\'hidden\' name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n<input type=\'hidden\' name=\'restrict_check";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'restrict_check";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<input type=\'hidden\' name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' id=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n<input type=\'hidden\' name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n<input type=\'hidden\' name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' id=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\'hidden\' name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' id=\'cred_auth_req_yn";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n<input type=\'hidden\' name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' id=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n<input type=\'hidden\' name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' id=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n<input type=\'hidden\' name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' id=\'pol_validity_chk_date";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n<input type=\'hidden\' name=\'rec_edited_YN";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' id=\'rec_edited_YN";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\n<input type=\'hidden\' name=\'payerEligibilityParam";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' id=\'payerEligibilityParam";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\n<input type=\'hidden\' name=\'responseCode";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' id=\'responseCode";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n<input type=\'hidden\' name=\'responseCodeDesc";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' id=\'responseCodeDesc";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n<input type=\'hidden\' name=\'statuDescription";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' id=\'statuDescription";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n<input type=\'hidden\' name=\'validityPeriod";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' id=\'validityPeriod";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n<input type=\'hidden\' name=\'validityPeriodDesc";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' id=\'validityPeriodDesc";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n<input type=\'hidden\' name=\'eligibilityCode";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' id=\'eligibilityCode";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n<input type=\'hidden\' name=\'transactionId";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id=\'transactionId";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n<input type=\'hidden\' name=\'responseDateTime";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' id=\'responseDateTime";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n<input type=hidden name=\'billing_group_desc";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\n<tr id=row";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =">\n\n\n<input type=hidden name=\'blng_grp_code";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\n<input type= \"hidden\" name=\"payerEligibilityParam";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" id=\"payerEligibilityParam";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"  value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\n<input type= \"hidden\" name=\"responseCode";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"responseCode";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" value=\"\">\n<input type= \"hidden\" name=\"responseCodeDesc";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" id=\"responseCodeDesc";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" value=\"\">\n<input type= \"hidden\" name=\"statuDescription";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" id=\"statuDescription";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" value=\"\">\n<input type= \"hidden\" name=\"validityPeriod";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" id=\"validityPeriod";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" value=\"\">\n<input type= \"hidden\" name=\"validityPeriodDesc";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" id=\"validityPeriodDesc";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" value=\"\">\n<input type= \"hidden\" name=\"eligibilityCode";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" id=\"eligibilityCode";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" value=\"\">\n<input type= \"hidden\" name=\"transactionId";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" id=\"transactionId";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" value=\"\">\n<input type= \"hidden\" name=\"responseDateTime";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" id=\"responseDateTime";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" value=\"\">\n\n<td class=";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =");\'  readonly></td>\n\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\"readonly></td>\n<input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n<input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n<input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n<input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'  readonly></td> \n\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" readonly></td>\n<input type=\'hidden\' name=\'policy_type_code";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'   value=\"\"  readonly></td>\n\n<td class=";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' size=\'10\' maxlength=\'10\' value=\'\'   readonly></td>\n\n<td class=";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' size=\'10\' maxlength=\'10\' value=\'\' readonly></td>\n\n<td class=";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'   value=\"\"   readonly></div></td>\n\n<td class=";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"></b></td>\n<td class=";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' style=\'text-align:right\'  value=\'\'  readonly></div></td>\n\n<td  class=";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' style=\'text-align:right\'  value=\'\'  readonly></div></td>\n\t\n<td class=";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' size=\'10\' maxlength=\'10\' value=\'\' readonly></td>\n</tr>\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n<input type=hidden name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n<input type=hidden name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n<input type=hidden name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n<input type=hidden name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n<input type=hidden name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n<input type=hidden name=\'restrict_check";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n<input type=hidden name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n<input type=hidden name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n<input type=hidden name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n<input type=hidden name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\n\n\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\n<input type=\'hidden\' name=\'focussed_row\' id=\'focussed_row\' value=\'\' >\n<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" >\n<input type=\"hidden\" name=\"policy_coverage_basis_gbl_ind\" id=\"policy_coverage_basis_gbl_ind\" value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\' >\n<input type=\"hidden\" name=\"policy_coverage_basis_gbl_ind_from_main\" id=\"policy_coverage_basis_gbl_ind_from_main\"  value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n<input type=\"hidden\" name=\'max_priority\' id=\'max_priority\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\' >\n<input type=\"hidden\" name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' >\n<input type=\"hidden\" name=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' >\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n\n</tbody>\n</table>\n</div>\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" \n\n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs4				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;

	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
//		System.err.println("querstring  in grpbody.jsp page:"+request.getQueryString());
		String sys_date="";
		int totalRecords=0;
		int selected_index=0;
		String total_records="";
		String checked_row="";
		String classval="";
		String facility_id = (String)httpSession.getValue("facility_id");

//		String queryString=(request.getQueryString());
//		System.out.println("queryString in multi:"+queryString);

		String valid_payer_YN="";
		String valid_policy_type_code_YN="";
		String cust_group_code="", cust_group_name="";;
		String policy_coverage_basis_ind="";
		String policy_coverage_basis_gbl_ind="";
		String policy_coverage_basis_gbl_ind_from_main="";

		String policy_start_date_conv="";
		String policy_exp_date_conv="";
		String credit_auth_date_conv="";
		String policy_eff_frm_date_conv="";
		String policy_eff_to_date_conv="";

		String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
		String v_display_hide_cred_auth="";
		String cred_auth_req_yn = "", dflt_auth_ref_as_pol_no_yn = "",cred_auth_mand_capt_yn="";

		String pol_validity_chk_date="";

		String encounter_date_time = "", encounter_date_aft_trunc="", encounter_date="";

		String cust_valid_from_date = "" ,cust_valid_to_date = "";

		String fin_class_flag_YN="N",autoFinChk="N",class_code="";

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";

		ArrayList existing_records_array=new ArrayList();

		policy_coverage_basis_gbl_ind_from_main=request.getParameter("policy_coverage_basis_gbl_ind_from_main");
		if(policy_coverage_basis_gbl_ind_from_main==null) policy_coverage_basis_gbl_ind_from_main="";

		String billing_group=request.getParameter("billing_group");
		if(billing_group==null) billing_group="";

		String p_patient_class  = request.getParameter("patient_class");
		String strModuleId = "",episode_type="";

		String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";

		String rec_edited_YN="N", payer_suspended_YN="", policy_suspended_YN="";

		strModuleId=request.getParameter("calling_module_id");
		if(strModuleId==null) strModuleId="";

		String str_max_priority=request.getParameter("max_priority");
//		System.out.println("str_max_priority:"+str_max_priority);
		if(str_max_priority == null || str_max_priority.equals("")) str_max_priority="0";

		int max_priority=Integer.parseInt(str_max_priority);

		if(p_patient_class ==null || (p_patient_class.equals("")))
		{
			if(strModuleId.equals("MP")) p_patient_class="XT";
			else if(strModuleId.equals("EM")) p_patient_class="EM";
			else if(strModuleId.equals("OP")) p_patient_class="OP";
			else if(strModuleId.equals("IP")) p_patient_class="IP";
			else if(strModuleId.equals("DC")) p_patient_class="DC";
		}

		if(strModuleId.equals("MP")) episode_type="R";
		else if(strModuleId.equals("AE")) episode_type="E";
		else if(strModuleId.equals("OP")) episode_type="O";
		else if(strModuleId.equals("IP")) episode_type="I";
		else if(strModuleId.equals("DC")) episode_type="D";

		try
		{
			String sql_trunc_time="select to_char( (to_date('"+encounter_date_time+"','dd/mm/yyyy HH24:MI')),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy') from dual";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_trunc_time) ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
					sys_date = rs.getString(2);
				}
			}
			if (rs != null)   rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}
		if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";
		if(sys_date == null) sys_date="";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";
		
		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";

		if(!encounter_date_aft_trunc.equals(""))
		{
			if(!locale.equals("en"))
			{
				encounter_date_aft_trunc=com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale);
			}
		}
/*
		if(autoFinChk.equals("Y"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				System.err.println("Inside Class Loop in insbody.jsp");
				class_code = ((String)bl_data.get("class_code")).trim();
			}
		}
*/
//		System.out.println("Encounter Date in MultiBlngGrpBody.jsp after Trunc of Time:"+encounter_date_aft_trunc);

		String remove_check=request.getParameter("remove_check");
		if(remove_check==null) remove_check="";

		if(remove_check.equals("remove"))
		{
			total_records=request.getParameter("total_records");
			if(total_records==null) total_records="0";

			totalRecords=Integer.parseInt(total_records);
			
			checked_row=request.getParameter("checked_row");
			if(checked_row==null) checked_row="0";
			selected_index=Integer.parseInt(checked_row);

//			System.out.println("total_records:"+total_records);
//			System.out.println("selected_index:"+selected_index);

			for(int i=0;i<totalRecords;i++)
			{
				if(!(i==selected_index))
				{
					policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";
				
					policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
						if(policy_exp_date_conv==null) policy_exp_date_conv="";

					credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
						if(credit_auth_date_conv==null) credit_auth_date_conv="";

					policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
						if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	
					policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
						if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";

					if(!locale.equals("en"))
					{
						if(!policy_start_date_conv.equals(""))
							policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
		
						if(!policy_exp_date_conv.equals(""))
							policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
	
						if(!credit_auth_date_conv.equals(""))
							credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
				
						if(!policy_eff_frm_date_conv.equals(""))
							policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");

						if(!policy_eff_to_date_conv.equals(""))
							policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
					}

					//String[] records=new String[35];
					String[] records=new String[45];
					records[0]=request.getParameter("blng_grp_code"+i);
					records[1]=request.getParameter("payer_desc"+i);
					records[2]=request.getParameter("cust_3"+i);
					records[3]=request.getParameter("priority"+i);
					records[4]=request.getParameter("policy_type_desc"+i);
					records[5]=request.getParameter("policy_type_code"+i);
					records[6]=request.getParameter("policy_no"+i);
//					records[7]=request.getParameter("policy_start_date"+i);
					records[7]=policy_start_date_conv;
//					records[8]=request.getParameter("policy_exp_date"+i);
					records[8]=policy_exp_date_conv;
					records[9]=request.getParameter("credit_auth_ref"+i);
//					records[10]=request.getParameter("credit_auth_date"+i);
					records[10]=credit_auth_date_conv;
					records[11]=request.getParameter("credit_apprd_amt"+i);
					records[12]=request.getParameter("credit_apprd_days"+i);
//					records[13]=request.getParameter("policy_eff_frm_date"+i);
					records[13]=policy_eff_frm_date_conv;
//					records[14]=request.getParameter("policy_eff_to_date"+i);
					records[14]=policy_eff_to_date_conv;
					records[15]=request.getParameter("adj_rule_ind"+i);
					records[16]=request.getParameter("adj_perc_amt_ind"+i);
					records[17]=request.getParameter("adj_perc_amt_value"+i);
					records[18]=request.getParameter("pmnt_diff_adj_int"+i);
					records[19]=request.getParameter("drg_pmnt_diff_adj_int"+i);
					records[20]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
					records[21]=request.getParameter("restrict_check"+i);
					records[22]=request.getParameter("valid_payer_YN"+i);
					records[23]=request.getParameter("valid_policy_type_code_YN"+i);
					records[24]=request.getParameter("ins_cust_group_code"+i);
					records[25]=request.getParameter("policy_coverage_basis_ind"+i);
					records[26]=request.getParameter("apprd_amt_restrict_check"+i);
					records[27]=request.getParameter("apprd_days_restrict_check"+i);
					records[28]=request.getParameter("cred_auth_req_yn"+i);
					records[29]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
					records[30]=request.getParameter("cust_valid_from_date"+i);
					records[31]=request.getParameter("cust_valid_to_date"+i);
					records[32]=request.getParameter("ins_cust_group_name"+i);
					records[33]=request.getParameter("rec_edited_YN"+i);
					records[34]=request.getParameter("cred_auth_mand_capt_yn"+i);
					
					records[35]=request.getParameter("payerEligibilityParam"+i);
					records[36]=request.getParameter("responseCode"+i);
					records[37]=request.getParameter("responseCodeDesc"+i);
					records[38]=request.getParameter("statuDescription"+i);
					records[39]=request.getParameter("validityPeriod"+i);
					records[40]=request.getParameter("validityPeriodDesc"+i);
					records[41]=request.getParameter("eligibilityCode"+i);
					records[42]=request.getParameter("transactionId"+i);
					records[43]=request.getParameter("responseDateTime"+i);

					existing_records_array.add(records);
				}
			}
		}
/*
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			stmt = con.createStatement();
			rs4 = stmt.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date = rs4.getString(1);
				}
			}
			if(rs4 != null) rs4.close();
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception :"+e);
		}
*/

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

if(remove_check.equals("remove"))
{
		//String[] output1=new String[34];
		System.out.println("remove check...prithivi...");
		String[] output1=new String[44];
		totalRecords=0;
	
		for(int i=0;i<existing_records_array.size();i++)
		{
			
			output1=(String[])existing_records_array.get(i);

			System.out.println("remove check...prithivi...output1.get(i) size..."+output1.length);

			policy_coverage_basis_ind=output1[25];	

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
			String billing_grp_qry="SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+output1[0]+"' AND LANGUAGE_ID = '"+locale+"'";
		
			String blng_grp_long_desc="";
			pstmt = con.prepareStatement(billing_grp_qry);
			rs2=pstmt.executeQuery();
			if( rs2 != null ) 
			{
				while(rs2.next())
				{
					blng_grp_long_desc=rs2.getString(1);
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();
//			System.out.println("output1[32]:"+output1[32]);

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(output1[32]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(output1[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[2]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[32]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[24]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[22]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[31]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(output1[3]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(output1[4]));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[5]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[23]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[6]));
            _bw.write(_wl_block61Bytes, _wl_block61);

	policy_start_date_conv=(String)output1[7];	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(policy_start_date_conv));
            _bw.write(_wl_block66Bytes, _wl_block66);

	policy_exp_date_conv=(String)output1[8];	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(policy_exp_date_conv));
            _bw.write(_wl_block69Bytes, _wl_block69);

//	System.out.println("In output1[28]:"+output1[28]);
//	System.out.println("In output1[29]:"+output1[29]);
	if(output1[28].equals("Y"))
	{
		if(output1[29].equals("Y"))
		{
			String temp_str=output1[6];
			if(!temp_str.equals("") && output1[9].equals(""))
			{
				if(temp_str.length() <= 20)
				{
					output1[9] = temp_str.substring(0,temp_str.length());
				}
				else
				{
					output1[9] = temp_str.substring(0,20);
				}
			}
		}
//		System.out.println("In here:"+output1[10]);
		output1[10] = encounter_date_aft_trunc;
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
		output1[9] = "";
		output1[10] = "";
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[9]));
            _bw.write(_wl_block74Bytes, _wl_block74);

	credit_auth_date_conv=(String)output1[10];	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(credit_auth_date_conv));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);

	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	
	if(output1[21].equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (output1[21].equals("R"))
	{
		if(output1[26].equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(output1[27].equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(output1[11]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(output1[12]));
            _bw.write(_wl_block94Bytes, _wl_block94);

	policy_eff_frm_date_conv=(String)output1[13];	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(policy_eff_frm_date_conv));
            _bw.write(_wl_block99Bytes, _wl_block99);

	policy_eff_to_date_conv=(String)output1[14];	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(policy_eff_to_date_conv));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[15]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[16]));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[17]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[19]));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[20]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[21]));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[26]));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[27]));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[25]));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[34]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[29]));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(output1[33]));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[35]));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[36]));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[37]));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[38]));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[39]));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[40]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[41]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[42]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(output1[43]));
            _bw.write(_wl_block151Bytes, _wl_block151);

		totalRecords++;
	}
}
else
{
//	System.out.println("Checking");
	int priority_count=max_priority;

	String billing_grp_qry="SELECT SHORT_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID = '"+billing_group+"' AND LANGUAGE_ID = '"+locale+"'";
	String blng_grp_long_desc="";
	pstmt = con.prepareStatement(billing_grp_qry);
	rs2=pstmt.executeQuery();
	if( rs2 != null ) 
	{
		while(rs2.next())
		{
			blng_grp_long_desc=rs2.getString(1);
			if(blng_grp_long_desc == null) blng_grp_long_desc="";
		}
	}
	if(rs2 != null) rs2.close();
	pstmt.close();

//	String sql_default="SELECT DISTINCT a.cust_code cust_code,DECODE(a.cust_code,'**',NULL, c.short_name) cust_short_name,a.policy_type_code policy_type_code,b.short_desc policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,c.cust_group_code cust_group_code,d.policy_coverage_basis,e.short_desc FROM bl_payers_priority_by_bg a, bl_ins_policy_types_lang_vw b,ar_customer_lang_vw c,bl_ins_policy_type_hdr d,ar_cust_group_lang_vw E,bl_cust_by_cust_group f WHERE a.operating_facility_id ='"+facility_id+"' AND a.blng_grp_id ='"+billing_group+"' AND a.patient_class ='"+p_patient_class+"' AND b.language_id = '"+locale+"' AND b.operating_facility_id = a.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND b.policy_type_code = a.policy_type_code AND b.policy_type_code = d.policy_type_code AND c.language_id = b.language_id AND b.language_id = e.language_id ORDER BY a.priority_no";	

//New Query for CRF-134 ( Multiple Cust Group for single Customer
//interface column Added in sql_default by prithivi on 03/05/2017 for mms-qh-crf-0085. bupa payer eligibility check
	String sql_default="";

	if(autoFinChk.equals("Y"))
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null  policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,BL_APPL_BG_BY_CLASSFCTN g"
		+" WHERE a.operating_facility_id ='"+facility_id+"'" 
		+" AND a.blng_grp_id ='"+billing_group+"'"
		+" AND a.blng_grp_id =g.APPL_BLNG_GRP_ID"
		+" AND g.CLASSIFICATION_CODE='"+class_code+"'"
		+" AND a.patient_class ='"+p_patient_class+"'" 
//		+" AND b.language_id = '"+locale+"'"
		+" and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE"
		+" and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE"
		+" AND a.operating_facility_id = b.operating_facility_id" 
		+" AND a.operating_facility_id = d.operating_facility_id" 
		+" AND a.operating_facility_id = g.operating_facility_id" 
		+" AND (c.cust_code = a.cust_code OR a.cust_code='**')" 
		+" AND c.cust_code=f.cust_code"
		+" AND f.cust_code=g.APPL_CUST_CODE"
		+" AND a.policy_type_code = b.policy_type_code" 
		+" AND a.policy_type_code = d.policy_type_code" 
		+" AND a.cust_group_code=f.cust_group_code"
		+" AND a.cust_group_code=d.cust_group_code" 
		+" AND d.cust_group_code=e.cust_group_code" 
		+" AND d.cust_group_code=g.APPL_CUST_GROUP_CODE"
//		+" AND c.language_id = b.language_id" 
//		+" AND b.language_id = e.language_id" 
		+" ORDER BY a.priority_no";
	}
	else
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null  policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,bl_blng_grp g "
		+" WHERE a.operating_facility_id ='"+facility_id+"'" 
		+" AND a.blng_grp_id ='"+billing_group+"'"
		+" AND g.dflt_payer_dtls_during_regn_yn ='Y' and  nvl(a.status,'E') = 'E'" // Karthik added
		+" AND a.patient_class ='"+p_patient_class+"'" 
//		+" AND b.language_id = '"+locale+"'"
		+" and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE"
		+" and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE"		
		+" AND a.operating_facility_id = b.operating_facility_id" 
		+" AND a.operating_facility_id = d.operating_facility_id" 
		+" AND (c.cust_code = a.cust_code OR a.cust_code='**')" 
		+" AND c.cust_code=f.cust_code"
		+" AND a.policy_type_code = b.policy_type_code" 
		+" AND a.policy_type_code = d.policy_type_code" 
		+" AND a.cust_group_code=f.cust_group_code"
		+" AND a.cust_group_code=d.cust_group_code" 
		+" AND d.cust_group_code=e.cust_group_code" 
//		+" AND c.language_id = b.language_id" 
//		+" AND b.language_id = e.language_id" 
		+" ORDER BY a.priority_no";
	}
	System.err.println("sql_default in Sec Ins BG:"+sql_default);
	pstmt = con.prepareStatement(sql_default);
	rs2 = pstmt.executeQuery() ;
	if( rs2 != null ) 
	{
		int i=0;

		while( rs2.next() )
		{
			//Added by prithivi on 03/05/2017 for mms-qh-crf-0085. This param is used for payer eligibility check
			String payerEligibilityParam="9";

			String cust_code=rs2.getString(1);
			if(cust_code==null || cust_code.equals("")) cust_code="";
			String cust_short_name="";
//			String cust_short_name=rs2.getString(2);
//			if(cust_short_name==null || cust_short_name.equals("")) cust_short_name="";
			String policy_type_code=rs2.getString(3);
			if(policy_type_code==null || policy_type_code.equals("")) policy_type_code="";
			String policy_short_desc="";
//			String policy_short_desc=rs2.getString(4);
//			if(policy_short_desc==null || policy_short_desc.equals("")) policy_short_desc="";
			String priority_no=rs2.getString(5);
			if(priority_no==null || priority_no.equals("")) priority_no="";

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

			cust_group_code=rs2.getString(12);
			if(cust_group_code==null || cust_group_code.equals("")) cust_group_code="";

//			cust_group_name=rs2.getString(14);
//			if(cust_group_name==null || cust_group_name.equals("")) cust_group_name="";

			policy_coverage_basis_ind=rs2.getString(13);
			if(policy_coverage_basis_ind==null || policy_coverage_basis_ind.equals("")) policy_coverage_basis_ind="";

			String interfaceYNcustgroup = rs2.getString(15);
			if(interfaceYNcustgroup==null || interfaceYNcustgroup.equals("")) interfaceYNcustgroup="";

			System.out.println("AddmodifyPatFinDetailsMultiBlngGrpBody.jsp...interfaceYNcustgroup...."+interfaceYNcustgroup);

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

			String cust_grp_desc_qry = "select short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and cust_group_code = '"+cust_group_code+"'";

			try
			{
				pstmt = con.prepareStatement(cust_grp_desc_qry);
				rs4 = pstmt.executeQuery() ;
				if( rs4 != null ) 
				{	
					while( rs4.next() )
					{  
						cust_group_name = rs4.getString(1);
					}
				}
				if (rs4 != null) rs4.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_qry:"+e);
			}
			if(cust_group_name == null) cust_group_name="";

			String cust_desc_qry = "select DECODE('"+cust_code+"','**',NULL, short_name) cust_short_name from ar_customer_lang_vw  where language_id='"+locale+"' and cust_code = '"+cust_code+"'";
			System.err.println("Exception in ref_src_code_qry:"+cust_desc_qry);
			try
			{
				pstmt = con.prepareStatement(cust_desc_qry);
				rs4 = pstmt.executeQuery() ;
				if( rs4 != null ) 
				{	
					while( rs4.next() )
					{  
						cust_short_name = rs4.getString(1);
					}
				}
				if (rs4 != null) rs4.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_qry:"+e);
			}
			if(cust_short_name == null) cust_short_name="";

			String policy_type_desc_qry = "select short_desc policy_short_desc from bl_ins_policy_types_lang_vw  where language_id='"+locale+"' and policy_type_code = '"+policy_type_code+"'";

			try
			{
				pstmt = con.prepareStatement(policy_type_desc_qry);
				rs4 = pstmt.executeQuery() ;
				if( rs4 != null ) 
				{	
					while( rs4.next() )
					{  
						policy_short_desc = rs4.getString(1);
					}
				}
				if (rs4 != null) rs4.close();
				pstmt.close();	
			}
			catch(Exception e)
			{
				System.out.println("Exception in ref_src_code_qry:"+e);
			}
			if(policy_short_desc == null) policy_short_desc="";

            _bw.write(_wl_block2Bytes, _wl_block2);

	if(i==0)
	{

            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block151Bytes, _wl_block151);

	}
	else
	{

            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block151Bytes, _wl_block151);

	}

//Added by prithivi on 29/12/2016 for mms-qh-crf-0085. bupa payer eligibility check
	String check_profileId="ELCPROF1";
	String profile_id_exists="N";
	String moduleIdCheck = InterfaceUtil.checkModuleIdForPayerEligibility(strModuleId);

    profile_id_exists = InterfaceUtil.isInterfaceProfileExisting(check_profileId);
    
	if("Y".equals(profile_id_exists) && "Y".equals(moduleIdCheck) )
	{ 
		System.out.println("AddmodifyPatfindetailsmultiblnggrpbody.jsp...in loop interfaceYNcustgroup,..."+interfaceYNcustgroup);
		if("Y".equals(interfaceYNcustgroup))
		{
		  payerEligibilityParam="0";
		}
		else
		{
          payerEligibilityParam="9";
		}
	}
	System.out.println("AddmodifyPatfindetailsmultiblnggrpbody.jsp...payerEligibilityParam.."+i+".."+payerEligibilityParam);

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(payerEligibilityParam));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cust_group_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block175Bytes, _wl_block175);

	try
	{
		String empty_sql_check="N";
//		String valid_payer_YN_sql="select DISTINCT 'Y',to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_ins_policy_type_hdr d,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and c.acc_entity_id = d.operating_facility_id and a.patient_flag = 'Y' 	and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and d.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code and d.cust_group_code = e.cust_group_code and (('"+strModuleId+"' in ('OP','AE') and nvl(d.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(d.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(d.external_covered,'N') = 'Y'))	AND d.CUST_CODE ='"+cust_code+"' and d.cust_group_code='"+cust_group_code+"'";

		String valid_payer_YN_sql="select DISTINCT 'Y',to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,a.status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' 	and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' /*and a.status is null*/ and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code and a.CUST_CODE ='"+cust_code+"' and b.cust_group_code='"+cust_group_code+"'";

//		System.out.println("valid_payer_YN_sql:"+valid_payer_YN_sql);
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
	}
	catch(Exception e)
	{
		System.out.println("Exception in valid_payer_YN_sql:"+e);
	}
	if(valid_payer_YN.equals("")) valid_payer_YN="N";
	if(cust_valid_from_date == null) cust_valid_from_date= "";
	if(cust_valid_to_date == null) cust_valid_to_date= "";


            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cust_short_name));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cust_group_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(valid_payer_YN));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(priority_count));
            _bw.write(_wl_block180Bytes, _wl_block180);

	try
	{
		String empty_sql_check="N";
		String valid_policy_type_code_YN_sql="Select DISTINCT 'Y',a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id='"+locale+"' and  a.operating_facility_id='"+facility_id+"' /*and nvl(a.status,'N') <> 'S'*/ and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code='"+cust_code+"' and b.cust_group_code='"+cust_group_code+"' and c.cust_group_code = b.cust_group_code and b.cust_code=c.cust_code and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y')) and b.policy_type_code='"+policy_type_code+"'";
//		System.out.println("valid_policy_type_code_YN_sql:"+valid_policy_type_code_YN_sql);
		pstmt = con.prepareStatement(valid_policy_type_code_YN_sql);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			valid_policy_type_code_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				valid_policy_type_code_YN=rs.getString(1);
				policy_suspended_YN = rs.getString(2);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();

		if(empty_sql_check.equals("Y"))
		{
			valid_policy_type_code_YN_sql="Select DISTINCT 'Y',a.status from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c where a.language_id='"+locale+"' and  a.operating_facility_id='"+facility_id+"' /*and nvl(a.status,'N') <> 'S'*/ and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and  b.cust_group_code='"+cust_group_code+"' and c.cust_group_code = b.cust_group_code and b.cust_code = '**' and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y')) and b.policy_type_code='"+policy_type_code+"'";
//			System.out.println("valid_policy_type_code_YN_sql when no data found:"+valid_policy_type_code_YN_sql);
			pstmt = con.prepareStatement(valid_policy_type_code_YN_sql);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{	
				empty_sql_check="Y";
				valid_policy_type_code_YN="";
				while(rs.next())
				{
					valid_policy_type_code_YN=rs.getString(1);
					policy_suspended_YN = rs.getString(2);
				}
			}
			if(rs != null) rs.close();
			pstmt.close();
		}	
	}
	catch(Exception e)
	{
		System.out.println("Exception in valid_policy_type_code_YN_sql:"+e);
	}
	if(valid_policy_type_code_YN.equals("")) valid_policy_type_code_YN="N";

	if(!(policy_type_code.equals("") && cust_code.equals("")))
	{
	String restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '"+cust_code+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+cust_group_code+"'";
//	System.out.println("restrict_check_sql:"+restrict_check_sql);
	String empty_sql_check="N";
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";

//	System.out.println("restrict_check_sql:"+restrict_check_sql);
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
		restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code='"+cust_group_code+"'";

//		System.out.println("restrict_check_sql1:"+restrict_check_sql);
	
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
		encounter_date = encounter_date_aft_trunc;
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		encounter_date = "";
		v_display_hide_cred_auth = "display:none";
	}

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(policy_short_desc));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(valid_policy_type_code_YN));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(adj_rule_ind));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(adj_perc_amt_ind));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(adj_perc_amt_value));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pmnt_diff_adj_int));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drg_pmnt_diff_adj_int));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(spl_srv_pmnt_diff_adj_int));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(restrict_check));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apprd_amt_restrict_check));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apprd_days_restrict_check));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cred_auth_req_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cred_auth_mand_capt_yn));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dflt_auth_ref_as_pol_no_yn));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rec_edited_YN));
            _bw.write(_wl_block203Bytes, _wl_block203);

		i++;
		}
		totalRecords=i;
		if(rs2 != null) rs2.close();
		pstmt.close();	
	}
}

            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(policy_coverage_basis_gbl_ind));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(policy_coverage_basis_gbl_ind_from_main));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(max_priority));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block214Bytes, _wl_block214);

	}
	catch(Exception e )
	{ 
		System.out.println("Main Exception:"+e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block215Bytes, _wl_block215);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_POLICY_DTLS.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_START_DATE.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EXPIRY_DATE.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH_DATE.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
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
}
