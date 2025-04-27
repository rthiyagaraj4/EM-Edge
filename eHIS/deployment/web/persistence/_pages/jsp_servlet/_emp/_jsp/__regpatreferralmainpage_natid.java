package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspWriter;

public final class __regpatreferralmainpage_natid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegPatReferralMainPage_NatID.jsp", 1742454240245L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eMP/js/RegPatReferral.js\' language=\'javascript\'></script>\t\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \t\n\t\t<script>\n\t\tfunction tab_click1(id1){\n\t\t\t\n\t\t\t//alert(id1);\n\t\t\tselectTab(id1);\n\t\t\t\n\t\t\ttab_click(id1);\n\t        }\n\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\n\t\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown =\'lockKey()\' onSelect = \"resMove()\" >\n\t\t\t<form name=\"RegPatReferral_form\" id=\"RegPatReferral_form\" >\n\t\t\t\t<input type=\'hidden\' name=\'ct_tab_name\' id=\'ct_tab_name\' >\n\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" tabindex=-1>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=label  width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td><td><input type=\"text\" name=\"ref_id\" id=\"ref_id\"  value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" size = 15 readonly tabindex=-1></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td align=left class = label colspan=4 ></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t</table>\n\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" tabindex=-1>\n\t\t\t\t<tr >\n\t\t\t\t\t<td colspan=4>\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=4 ></td>\n\t\t\t\t</tr>\n\t\t\t \t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=\"hidden\" name=\"operation_type\" id=\"operation_type\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n \t\t<input type=\'hidden\' name=\'serdang\' id=\'serdang\' value=\'serdang\'>\n\t\t<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\t\t\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'REGISTER_PAT_REFERRAL\'>\n\t\t<input type=\'hidden\' name=\'calling_from\' id=\'calling_from\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\t\n\t\t<input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'race_code1\' id=\'race_code1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_calling_function\' id=\'p_calling_function\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\t\n\t\t<input type=\'hidden\' name=\'ass_func_id\' id=\'ass_func_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=\'hidden\' name=\'citizenvalue\' id=\'citizenvalue\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'illegalvalue\' id=\'illegalvalue\' value=\'\'>\t\t\n\t\t\n\t</form>\n</body>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<script>\n\t\t\t\tsetTimeout(\"populate_details()\",250);\n\t\t\t\tfunction populate_details()\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_id.readOnly==true)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.readOnly=false;\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.value =\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.readOnly=true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.value =\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\tdisableNatId();\n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'patient_name1\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'patient_name1\').innerHTML =\"<b>\"+\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\tif(parent.frames[1].document.getElementById(\'patient_name\'))\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'patient_name\').value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].name_prefix)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].name_prefix.value =\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].first_name)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].first_name.value =\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].second_name)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].second_name.value =\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].third_name)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].third_name.value =\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].family_name)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].family_name.value =\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].name_suffix)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].name_suffix.value =\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_name_local_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_name_local_lang.value =\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\tif(parent.frames[0].document.getElementById(\'patient_name_local_lang1\'))\n\t\t\t\t\t\tparent.frames[0].document.getElementById(\'patient_name_local_lang1\').innerHTML =\"<b>\"+\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].first_name_oth_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].first_name_oth_lang.value =\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].second_name_oth_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].second_name_oth_lang.value =\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].third_name_oth_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].third_name_oth_lang.value =\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].family_name_oth_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].family_name_oth_lang.value =\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].name_prefix_oth_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].name_prefix_oth_lang.value =\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].name_suffix_oth_lang)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].name_suffix_oth_lang.value =\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\n\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].sex)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].sex.value =\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].b_age)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].b_age.value =\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].b_months)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].b_months.value =\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].b_days)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].b_days.value =\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].date_of_birth)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].date_of_birth.value =\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].primary_resi_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].primary_resi_no.value =\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].other_resi_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].other_resi_no.value =\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].national_id_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].national_id_no.value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id1_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id1_no.value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"; \n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id2_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id2_no.value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id3_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id3_no.value =\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id4_no)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id4_no.value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id1_exp_date)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id2_exp_date)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id2_exp_date.value =\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id3_exp_date)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id3_exp_date.value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].alt_id4_exp_date)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].alt_id4_exp_date.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\t\t\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].nationality_code1)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].nationality_code1.value = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].nationality_desc)\n\t\t\t\t\tparent.frames[0].document.forms[0].nationality_desc.value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].birth_place)\n\t\t\t\t\tparent.frames[0].document.forms[0].birth_place.value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].place_of_birth)\n\t\t\t\t\tparent.frames[0].document.forms[0].place_of_birth.value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].birth_place_code)\n\t\t\t\t\tparent.frames[0].document.forms[0].birth_place_code.value = \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\n\t\t\t\t\tif (parent.frames[0].document.forms[0].addr_line1)\n\t\t\t\t\tparent.frames[0].document.forms[0].addr_line1.value =\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].addr_line2)\n\t\t\t\t\tparent.frames[0].document.forms[0].addr_line2.value =\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].addr_line3)\n\t\t\t\t\tparent.frames[0].document.forms[0].addr_line3.value =\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\t\t\t\tif (parent.frames[0].document.forms[0].addr_line4)\n\t\t\t\t\tparent.frames[0].document.forms[0].addr_line4.value =\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].res_town_code.value\t\t\t= \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].res_area_code.value\t\t\t\t = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].postal_code.value\t\t\t\t\t = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].r_postal_code_desc.value\t\t\t\t\t = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].region_code.value\t\t\t\t\t = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].country_code.value\t\t\t\t = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_addr_line1.value\t\t\t = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_addr_line2.value\t\t\t = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_addr_line3.value\t\t\t = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_addr_line4.value\t\t\t = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_res_town_code.value\t = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_res_area_code.value\t = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_postal_code.value\t     = \"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].m_postal_code_desc.value\t     = \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_region_code.value\t\t = \"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_country_code.value\t\t = \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].contact1_no.value = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].contact2_no.value = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].email.value = \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].res_town_desc.value = \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].res_area_desc.value = \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].region_desc.value = \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_res_town_desc.value = \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_res_area_desc.value = \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_region_desc.value = \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].country_desc.value = \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].mail_country_desc.value = \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t\t/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_addr_line1.value\t\t= \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_addr_line2.value\t\t= \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_addr_line3.value\t\t= \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_addr_line4.value\t\t= \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_area_code.value\t\t= \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_area_desc.value\t\t= \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_town_code.value\t\t= \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_town_desc.value\t\t= \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_postal_code.value\t= \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_postal_desc.value\t= \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_region_code.value\t= \"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_region_desc.value\t= \"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_country_code.value\t= \"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].alt_country_desc.value\t= \"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\";\n\t\t\t\t\t/*End*/\n\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"==\"Y\"){\n\t\t\t\t\tparent.frames[0].document.forms[0].citizen_yn[0].value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].citizen_yn[0].checked=true;\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\tparent.frames[0].document.forms[0].citizen_yn[1].value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].citizen_yn[1].checked=true;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"==\"Y\"){\n\t\t\t\t\tparent.frames[0].document.forms[0].legal_yn[0].value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].legal_yn[0].checked=true;\n\t\t\t\t\t}\n\t\t\t\t\telse{ \n\t\t\t\t\tparent.frames[0].document.forms[0].legal_yn[1].value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].legal_yn[1].checked=true;\n\t\t\t\t\t}\n\t\t\t\t\tparent.frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].ethnic_group.value = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tpopEthnicSubGroup(\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\",\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\");\n\t\t\t\t\t} \n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tpopOth_alt_type(\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\");\t\t\t\tif(\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"!=\"\")\n\t\t\t\t\t\t\tparent.frames[0].document.forms[0].other_alt_Id.value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\';\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tvar patient_id = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\";\n\t\t\n\t\t\t\t\tif (patient_id!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdisableItems()\t\t\t\t\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.readOnly=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t<script>\n\t\t\t\n\t\t\t\tif(parent.frames[1].document.getElementById(\"p_calling_function\") != null && parent.frames[1].document.getElementById(\"p_calling_function\").value == \"CHG_REG_DTLS\" ) \n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_id.readOnly==true)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.readOnly=false;\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.value =\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n              /*Below Line Added by Senthil for this incident[33096]*/\t\t\t\t\n\t\t\t\tif(parent.frames[1].document.getElementById(\"p_calling_function\")){\n\t\t\t\t\t//condition modified for the incident - ML-BRU-SCF-0946 [IN:041858] - IP_ADMIT, OP_REG_VISIT, AE_REGISTER_ATTN and IP_BOOKING included\n\t\t\t\tif(parent.frames[1].document.getElementById(\"p_calling_function\") != null && parent.frames[1].document.getElementById(\"p_calling_function\").value == \"CHG_ADM_DTLS\" || \n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"p_calling_function\").value == \"OA_BOOK_APPT\" || parent.frames[1].document.getElementById(\"p_calling_function\").value == \"OA_MODIFY_APPT\"|| \n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"p_calling_function\").value == \"REV_VISIT_DTLS\" || parent.frames[1].document.getElementById(\"p_calling_function\").value == \"CHG_REG_DTLS\" || \n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"p_calling_function\").value == \"IP_ADMIT\" || parent.frames[1].document.getElementById(\"p_calling_function\").value == \"OP_REG_VISIT\" ||\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"p_calling_function\").value == \"AE_REGISTER_ATTN\" || parent.frames[1].document.getElementById(\"p_calling_function\").value == \"IP_BOOKING\") {\n               \t\tparent.frames[0].document.forms[0].patient_id.value =\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_id != null && parent.frames[0].document.forms[0].patient_id.value != \'\'){\t\t\tparent.frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.disabled = true;\n\t\t\t\t\t\t\t\tparent.frames[0].document.forms[0].search.disabled = true;\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t\tif(parent.frames[0].document.forms[0].patient_id != null)\n\t\t\t\t{\t\n\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_id.disabled==false)\n\t\t\t\t\t{\n\t\t\t\t\t\t//parent.frames[0].document.forms[0].patient_id.focus();  // re-open 13835\n\t\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_id1)\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id1.blur();\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(parent.frames[1].document.getElementById(\'ca_patient_id\')) {\n\t\t\t\t\tif(parent.frames[1].document.getElementById(\'ca_patient_id\').value !=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.value =\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\";\n\t\t\t\t\t\t//parent.frames[0].document.forms[0].patient_id.readOnly=true;\n\t\t\t\t\t\t//parent.frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.disabled = true;\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="<script>currentTab = \"rejfrom_tab\";</script>\n\t\t ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="<script>currentTab = \"reffrom_tab\";</script>\n\t\t  ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" \n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n</html>\n\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String facilityid = (String) session.getValue("facility_id");
		Connection con=null;
		PreparedStatement pstmt=null;
		
		ResultSet mod_rs=null ;
		

		try
		{
			con = ConnectionManager.getConnection(request);	
			String pat_ID = (request.getParameter("pat_ID") == null)?"":request.getParameter("pat_ID");	
			String calling_from		= (request.getParameter("calling_from") == null)?"":request.getParameter("calling_from");	
			String p_calling_function		= (request.getParameter("p_calling_function") == null)?"":request.getParameter("p_calling_function");
			String ass_func_id="";
			if(p_calling_function.equals("OP_REG_VISIT"))
			{
				ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
			}	
			String referral_id	= (request.getParameter("referral_id") == null)?"":request.getParameter("referral_id");		
			String mode = (request.getParameter("mode") == null)?"insert":request.getParameter("mode");	
			if(mode.equals("")) mode="insert";
			String ca_patient_id= (request.getParameter("ca_patient_id") == null)?"":request.getParameter("ca_patient_id");
			StringBuffer mod_sql			= new StringBuffer();
			String patientid="";
		    String family_name_loc_lang="";
			String third_name_loc_lang="";
			String second_name_loc_lang="";
			String first_name_loc_lang="";
			String name_prefix_loc_lang="";
			String name_suffix_loc_lang="";
			String patient_name_loc_lang="";
			String mail_postal_desc="";
			String postal_desc="";
			String patient_name		= "";
			String name_prefix		= "";
			String first_name		= "";
			String second_name		= "";
			String third_name		= "";
			String family_name		= "";
			String name_suffix		= "";
			String sex				= "";
			String date_of_birth	= "";
			String nationality_code	= "";
			String display_nationality_desc	= "";
			String birth_place_desc	= "";
			String birth_place_code	= "";
			String birth_place_desc_referral = "";
			String addr_line1		= "";
			String addr_line2		= "";
			String addr_line3		= "";
			String addr_line4		= "";
			String contact1_no		= "";
			String contact2_no		= "";
			String age				= "";
			String months			= "";
			String days				= "";
			String national_id_no=""; 
			String alt_id1_id=""; 
			String alt_id2_id=""; 
			String alt_id3_id=""; 
			String alt_id4_id=""; 
			String alt_id1_date=""; 
			String alt_id2_date="";
			String alt_id3_date ="";
			String alt_id4_date ="";
			String res_town_code="";
			String res_area_code=""; 
			String country_code=""; 
			String postal_code="";
			String region_code="";
			String mail_addr_line1="";
			String mail_addr_line2=""; 
			String mail_addr_line3=""; 
			String mail_addr_line4=""; 
			String mail_res_town_code="";
			String mail_res_area_code=""; 
			String mail_region_code=""; 
			String mail_country_code =""; 
			String mail_postal_code =""; 
			String citizen_yn="";
			String legal_illegal_yn="";
			String race_code="";
			String race_desc="";
			String ethnic_grp_code="";
			String ethnic_grp_desc="";	
			String email_id="";
			String country1_desc="";
			String country2_desc="";
			String res_town_desc="";
			String res_area_desc="";
			String region_desc="";
			String mail_res_town_desc="";
			String mail_res_area_desc="";
			String mail_region_desc="";
			/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			String alt_addr_line1	= "";
			String alt_addr_line2	= "";
			String alt_addr_line3	= "";
			String alt_addr_line4	= "";
			String alt_postal_code  = "";
			String alt_postal_desc  = "";
			String alt_country_code = "";
			String alt_country_desc = "";
			String alt_area_code	= "";
			String alt_area_desc	= "";
			String alt_town_code	= "";
			String alt_town_desc	= "";
			String alt_region_code	= "";
			String alt_region_desc	= "";
			/*End*/
		
			String oth_alt_Id="";
			String oth_alt_type="";
			String oth_alt_id_type_desc="";
			if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
			{
				mod_sql.append("select a.national_id_no, a.alt_id1_no, a.alt_id2_no, a.alt_id3_no, a.alt_id4_no, to_char (a.alt_id1_date, 'dd/mm/yyyy') alt_id1_date, to_char (a.alt_id2_date, 'dd/mm/yyyy') alt_id2_date, to_char (a.alt_id3_date, 'dd/mm/yyyy') alt_id3_date, to_char(a.alt_id4_date, 'dd/mm/yyyy') alt_id4_date, a.res_town_code, mp_get_desc.mp_res_town(a.res_town_code, '"+locale+"','1') res_town_desc, a.res_area_code, mp_get_desc.mp_res_area(a.res_area_code, '"+locale+"','1') res_area_desc, a.country_code, mp_get_desc.mp_country(a.country_code, '"+locale+"','1') country1_desc, a.region_code, mp_get_desc.mp_region(a.region_code, '"+locale+"','2') region_desc, a.postal_code, mp_get_desc.mp_postal_code(a.postal_code, '"+locale+"','2') postal_desc, a.mail_res_town_code, mp_get_desc.mp_res_town(a.mail_res_town_code, '"+locale+"','1') mail_res_town_desc, a.mail_res_area_code, mp_get_desc.mp_res_area(a.mail_res_area_code, '"+locale+"','1') mail_res_area_desc, a.mail_country_code, mp_get_desc.mp_country(a.mail_country_code, '"+locale+"','1') country2_desc, a.mail_region_code, mp_get_desc.mp_region(a.mail_region_code, '"+locale+"','2') mail_region_desc,a.mail_postal_code, mp_get_desc.mp_postal_code(a.mail_postal_code, '"+locale+"','2') mail_postal_desc, a.race_code, mp_get_desc.mp_race(a.race_code, '"+locale+"','1') race_desc, a.nationality_code, mp_get_desc.mp_country(a.nationality_code, '"+locale+"','3') nationality_desc, a.birth_place_code, mp_get_desc.mp_birth_place(a.birth_place_code, '"+locale+"','1') birth_place_desc, a.ethnic_grp_code, mp_get_desc.mp_ethnic_group(a.ethnic_grp_code, '"+locale+"','1') ethnic_grp_desc, mp_get_desc.mp_alternate_id_type(a.oth_alt_id_type, '"+locale+"','1') oth_alt_id_type_desc,    a.mail_addr_line1, a.mail_addr_line2, a.mail_addr_line3, a.mail_addr_line4, a.citizen_yn, a.legal_illegal_yn, a.patient_id, a.patient_name, a.name_prefix, a.first_name, a.second_name, a.third_name, a.family_name, a.name_suffix, a.sex, to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth, calculate_age (to_char (a.date_of_birth, 'dd/mm/yyyy'), 1) age, calculate_age (to_char (a.date_of_birth, 'dd/mm/yyyy'), 2) months, calculate_age (to_char (a.date_of_birth, 'dd/mm/yyyy'), 3) days, a.nationality_code, birth_place_code, a.addr_line1, a.addr_line2, a.addr_line3, a.addr_line4, a.contact1_no, a.contact2_no, a.email_id, a.birth_place_desc birth_place_desc_referral, a.oth_alt_id_type, a.oth_alt_id_no, a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang, a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang, a.name_prefix_loc_lang, a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc from pr_referral_register a ");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
				if(mode.equals("modify"))
				{
					mod_sql.append(" where a.referral_id =? ");
				}
				else if(mode.equals("RegisterMoreReferral"))
				{
					if(!pat_ID.equals(""))
					{
					  mod_sql.append(" where a.patient_id =? order by a.referral_id ");
					}
					else
					{
						mod_sql.append(" where a.referral_id =? order by a.referral_id ");
					}
				}
				pstmt = con.prepareStatement(mod_sql.toString());
				if(mode.equals("modify"))
				{
					pstmt.setString(1,referral_id);
				}
				else if(mode.equals("RegisterMoreReferral"))
				{
					if(!pat_ID.equals(""))
					{
					pstmt.setString(1,pat_ID);
					}
					else
					{
					pstmt.setString(1,referral_id);
					}	
				}
				mod_rs = pstmt.executeQuery();
				while(mod_rs !=null&& mod_rs.next())
				{
					oth_alt_type = mod_rs.getString("oth_alt_id_type");
					if (oth_alt_type==null) oth_alt_type="";

					oth_alt_Id = mod_rs.getString("oth_alt_id_no");
					if (oth_alt_Id==null) oth_alt_Id="";

					oth_alt_id_type_desc = mod_rs.getString("oth_alt_id_type_desc");
					if (oth_alt_id_type_desc==null) oth_alt_id_type_desc="";					

					email_id = mod_rs.getString("email_id");
					if (email_id==null) email_id="";
					region_code             = mod_rs.getString("region_code");
					if (region_code==null) region_code="";

					mail_region_code                = mod_rs.getString("mail_region_code");
					if (mail_region_code==null) mail_region_code="";

					race_code               = mod_rs.getString("race_code");
					if (race_code==null) race_code="";		

					race_desc  = mod_rs.getString("race_desc");
					if (race_desc==null) race_desc="";	

					ethnic_grp_code     = mod_rs.getString("ethnic_grp_code");
					if (ethnic_grp_code==null) ethnic_grp_code="";						

					ethnic_grp_desc     = mod_rs.getString("ethnic_grp_desc");
					if (ethnic_grp_desc==null) ethnic_grp_desc="";

					legal_illegal_yn                = mod_rs.getString("legal_illegal_yn");
					if (legal_illegal_yn==null) legal_illegal_yn="";

					citizen_yn              = mod_rs.getString("citizen_yn");
					if (citizen_yn==null) citizen_yn="";

					alt_id2_date            = mod_rs.getString("alt_id2_date");
					if (alt_id2_date==null) alt_id2_date="";


					alt_id1_date            = mod_rs.getString("alt_id1_date");
					if (alt_id1_date==null) alt_id1_date="";

					alt_id4_id              = mod_rs.getString("alt_id4_no");
					if (alt_id4_id==null) alt_id4_id="";

					alt_id3_id              = mod_rs.getString("alt_id3_no");
					if (alt_id3_id==null) alt_id3_id="";

					alt_id2_id              = mod_rs.getString("alt_id2_no");
					if (alt_id2_id==null) alt_id2_id="";

					alt_id1_id              = mod_rs.getString("alt_id1_no");
					if (alt_id1_id==null) alt_id1_id="";

					national_id_no          = mod_rs.getString("national_id_no");
					if (national_id_no==null) national_id_no="";

					alt_id3_date            = mod_rs.getString("alt_id3_date");
					if (alt_id3_date==null) alt_id3_date="";

					alt_id4_date            = mod_rs.getString("alt_id4_date");
					if (alt_id4_date==null) alt_id4_date="";

					res_town_code           = mod_rs.getString("res_town_code");
					if (res_town_code==null) res_town_code="";
					mail_postal_code                = mod_rs.getString("mail_postal_code");
					if (mail_postal_code==null) mail_postal_code="";


					mail_country_code                = mod_rs.getString("mail_country_code");
					if (mail_country_code==null) mail_country_code="";

					mail_res_area_code              = mod_rs.getString("mail_res_area_code");
					if (mail_res_area_code==null) mail_res_area_code="";
					mail_res_town_code              = mod_rs.getString("mail_res_town_code");
					if (mail_res_town_code==null) mail_res_town_code="";
					mail_addr_line4          = mod_rs.getString("mail_addr_line4");
					if (mail_addr_line4==null) mail_addr_line4="";

					mail_addr_line3                 = mod_rs.getString("mail_addr_line3");
					if (mail_addr_line3==null) mail_addr_line3="";

					mail_addr_line2                 = mod_rs.getString("mail_addr_line2");
					if (mail_addr_line2==null) mail_addr_line2="";

					mail_addr_line1          = mod_rs.getString("mail_addr_line1");
					if (mail_addr_line1==null) mail_addr_line1="";

					res_area_code           = mod_rs.getString("res_area_code");
					if (res_area_code==null) res_area_code="";

					country_code            = mod_rs.getString("country_code");
					if (country_code==null) country_code="";


					postal_code              = mod_rs.getString("postal_code");
					if (postal_code==null) postal_code="";

					postal_desc              = mod_rs.getString("postal_desc");
					if (postal_desc==null) postal_desc="";

					mail_postal_desc              = mod_rs.getString("mail_postal_desc");
					if (mail_postal_desc==null) mail_postal_desc="";

					mail_region_desc            = mod_rs.getString("mail_region_desc");
					if (mail_region_desc==null) mail_region_desc="";

					mail_res_area_desc              = mod_rs.getString("mail_res_area_desc");
					if (mail_res_area_desc==null) mail_res_area_desc="";

					mail_res_town_desc            = mod_rs.getString("mail_res_town_desc");
					if (mail_res_town_desc==null) mail_res_town_desc="";

					region_desc              = mod_rs.getString("region_desc");
					if (region_desc==null) region_desc="";

					res_area_desc            = mod_rs.getString("res_area_desc");
					if (res_area_desc==null) res_area_desc="";

					res_town_desc              = mod_rs.getString("res_town_desc");
					if (res_town_desc==null) res_town_desc="";

					country2_desc            = mod_rs.getString("country2_desc");
					if (country2_desc==null) country2_desc="";

					country1_desc              = mod_rs.getString("country1_desc");
					if (country1_desc==null) country1_desc="";
					patientid			=mod_rs.getString("patient_id");
					if (patientid==null) patientid="";

					patient_name		=mod_rs.getString("patient_name");
					if (patient_name==null) patient_name="";
					name_prefix		=mod_rs.getString("name_prefix");
					if (name_prefix==null) name_prefix="";
					first_name			=mod_rs.getString("first_name");
					if (first_name==null) first_name="";
					second_name		=mod_rs.getString("second_name");
					if (second_name==null) second_name="";
					third_name			=mod_rs.getString("third_name");
					if (third_name==null) third_name="";
					family_name		=mod_rs.getString("family_name");
					if (family_name==null) family_name="";
					name_suffix		=mod_rs.getString("name_suffix");
					if (name_suffix==null) name_suffix="";

					patient_name_loc_lang		=mod_rs.getString("patient_name_loc_lang");
					if (patient_name_loc_lang==null) patient_name_loc_lang="";
					
					name_prefix_loc_lang		=mod_rs.getString("name_prefix_loc_lang");
					if (name_prefix_loc_lang==null) name_prefix_loc_lang="";

					first_name_loc_lang		=mod_rs.getString("first_name_loc_lang");
					if (first_name_loc_lang==null) first_name_loc_lang="";

					second_name_loc_lang		=mod_rs.getString("second_name_loc_lang");
					if (second_name_loc_lang==null) second_name_loc_lang="";

					third_name_loc_lang		=mod_rs.getString("third_name_loc_lang");
					if (third_name_loc_lang==null) third_name_loc_lang="";

					family_name_loc_lang		=mod_rs.getString("family_name_loc_lang");
					if (family_name_loc_lang==null) family_name_loc_lang="";

					name_suffix_loc_lang		=mod_rs.getString("name_suffix_loc_lang");
					if (name_suffix_loc_lang==null) name_suffix_loc_lang="";

					sex				=mod_rs.getString("sex");
					if (sex==null) sex="";
					date_of_birth		=mod_rs.getString("date_of_birth");
					if (date_of_birth==null) date_of_birth="";
					
					if ( !date_of_birth.equals("") )
					{
						if (!localeName.equals("en"))
						{
							date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",localeName); 
						}
					}
					age		=mod_rs.getString("age");
					if (age==null) age="";
					months		=mod_rs.getString("months");
					if (months==null) months="";
					days		=mod_rs.getString("days");
					if (days==null) days="";
					nationality_code	=mod_rs.getString("nationality_code");
					if (nationality_code==null) nationality_code="";

					display_nationality_desc	=mod_rs.getString("nationality_desc");
					if (display_nationality_desc==null) display_nationality_desc="";
					birth_place_desc	=mod_rs.getString("birth_place_desc");
					if (birth_place_desc==null) birth_place_desc="";

					birth_place_desc_referral = mod_rs.getString("birth_place_desc_referral");
					if (birth_place_desc_referral==null) birth_place_desc_referral="";

					birth_place_code	=mod_rs.getString("birth_place_code");
					if (birth_place_code==null) birth_place_code="";
					addr_line1			=mod_rs.getString("addr_line1");
					if (addr_line1==null) addr_line1="";
					addr_line2			=mod_rs.getString("addr_line2");
					if (addr_line2==null) addr_line2="";
					addr_line3			=mod_rs.getString("addr_line3");
					if (addr_line3==null) addr_line3="";
					addr_line4			=mod_rs.getString("addr_line4");
					if (addr_line4==null) addr_line4="";
					contact1_no		=mod_rs.getString("contact1_no");
					if (contact1_no==null) contact1_no="";
					contact2_no		=mod_rs.getString("contact2_no");
					if (contact2_no==null) contact2_no="";

					/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
					alt_addr_line1		= checkForNull(mod_rs.getString("alt_addr_line1"));
					alt_addr_line2		= checkForNull(mod_rs.getString("alt_addr_line2"));
					alt_addr_line3		= checkForNull(mod_rs.getString("alt_addr_line3"));
					alt_addr_line4		= checkForNull(mod_rs.getString("alt_addr_line4"));
					alt_area_code		= checkForNull(mod_rs.getString("alt_area_code"));
					alt_area_desc		= checkForNull(mod_rs.getString("alt_area_desc"));
					alt_town_code		= checkForNull(mod_rs.getString("alt_town_code"));
					alt_town_desc		= checkForNull(mod_rs.getString("alt_town_desc"));
					alt_region_code		= checkForNull(mod_rs.getString("alt_region_code"));
					alt_region_desc		= checkForNull(mod_rs.getString("alt_region_desc"));
					alt_postal_code		= checkForNull(mod_rs.getString("alt_postal_code"));
					alt_postal_desc		= checkForNull(mod_rs.getString("alt_postal_desc"));
					alt_country_code	= checkForNull(mod_rs.getString("alt_country_code"));
					alt_country_desc	= checkForNull(mod_rs.getString("alt_country_desc"));
					/*End*/

				}
				if(mod_rs != null) mod_rs.close();
				if(pstmt != null) pstmt.close();
				mod_sql.setLength(0);

			}
			
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			/*
				try
				{
					
					mod_sql.append("  select nvl(name_prefix_prompt,'')name_prefix_prompt, nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt,nvl(second_name_prompt,'')second_name_prompt, nvl(third_name_prompt,'') third_name_prompt, pat_name_as_multipart_yn, nvl(family_name_prompt,'')family_name_prompt, patient_id_length, NVL(nat_id_prompt,'National ID No') nat_id_prompt  from mp_param_lang_vw where language_id='"+locale+"'");
					
					pstmt=con.prepareStatement(mod_sql.toString());			
					rset = pstmt.executeQuery();
					if(rset!=null && rset.next())
					{				

						nat_id_prompt=rset.getString("nat_id_prompt");			
						if(nat_id_prompt== null) nat_id_prompt="";	
						nameprefixprompt		= rset.getString("NAME_PREFIX_PROMPT");
						firstnameprompt			= rset.getString("FIRST_NAME_PROMPT");
						secondnameprompt	= rset.getString("SECOND_NAME_PROMPT");
						thirdnameprompt		= rset.getString("THIRD_NAME_PROMPT");
						familynameprompt		= rset.getString("FAMILY_NAME_PROMPT");
						namesuffixprompt		= rset.getString("NAME_SUFFIX_PROMPT");
						//Added on 15/03/2003
						pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
						if(pat_name_as_multipart_yn==null) pat_name_as_multipart_yn="N";
						//End of addition on 15/03/2003			*/			
						
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);

				/*	}

					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					mod_sql.setLength(0);
				}catch(Exception e)
				{
					out.println("Exception in Nat ID modify :"+e);
					e.printStackTrace();
				}
			*/
				if(mode.equals("modify"))
				{	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
		
				}else{	
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
		
				if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
				{		
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1].frames[0]")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("reg_pat")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block16Bytes, _wl_block16);

				}
				else if(p_calling_function.equals("CHG_REG_DTLS"))
				{
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1].frames[0]")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("ae_reg_pat")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block16Bytes, _wl_block16);

				}
					else if(!ca_patient_id.equals(""))
				{ 
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1].frames[0]")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("ae_reg_pat")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block16Bytes, _wl_block16);
	
				}
				else
				{ 
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1].frames[0]")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("reg_pat")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block16Bytes, _wl_block16);
	
				}	
				
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!mode.equals("modify")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(calling_from));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ass_func_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
//condition modified for the incident - ML-BRU-SCF-0946 [IN:041858] - IP_ADMIT, AE_REGISTER_ATTN  and IP_BOOKING included
		if(mode.equals("RegisterMoreReferral") || p_calling_function.equals("CHG_REG_DTLS") || p_calling_function.equals("CHG_ADM_DTLS") ||
		p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT")  || !ca_patient_id.equals("") || 
		p_calling_function.equals("OP_REG_VISIT") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS") || p_calling_function.equals("IP_ADMIT") 
		|| p_calling_function.equals("AE_REGISTER_ATTN") || p_calling_function.equals("IP_BOOKING") )
		{
			patientid = pat_ID; 
			
		}

		if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
		{
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(age));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(months));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(days));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(contact1_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_id1_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(alt_id2_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(alt_id3_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(alt_id4_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alt_id1_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(alt_id2_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(alt_id3_date));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_id4_date));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(display_nationality_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(birth_place_desc_referral));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(postal_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mail_res_town_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mail_res_area_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(mail_postal_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(contact1_no));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(mail_res_town_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(mail_res_area_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(country1_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(country2_desc));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(legal_illegal_yn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(legal_illegal_yn));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(legal_illegal_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(ethnic_grp_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(ethnic_grp_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(ethnic_grp_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(ethnic_grp_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(oth_alt_type));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(oth_alt_type));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(oth_alt_id_type_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(oth_alt_Id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(oth_alt_Id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block129Bytes, _wl_block129);

		}
		
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block133Bytes, _wl_block133);

		if(mode.equals("modify"))
		 {
		 
            _bw.write(_wl_block134Bytes, _wl_block134);
}else{
            _bw.write(_wl_block135Bytes, _wl_block135);
}

		}catch(Exception e)
		{
			out.println("Exception in main Nat ID="+e);
			e.printStackTrace();
		}
		finally
		{
			try{	
			if(mod_rs!=null)	mod_rs.close();
			if(pstmt != null) pstmt.close();
			}catch(Exception ee){
			ee.printStackTrace();
			}

			ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block136Bytes, _wl_block136);
            _bw.write(_wl_block137Bytes, _wl_block137);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
}
