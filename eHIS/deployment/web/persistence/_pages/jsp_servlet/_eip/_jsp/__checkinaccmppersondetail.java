package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __checkinaccmppersondetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CheckinAccmpPersonDetail.jsp", 1742376700016L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../js/CheckinAccmpPerson.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</head>\n\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'AccPersonForm\' id=\'AccPersonForm\' method=\'post\' action=\'../../servlet/eIP.BookLodgerServlet\' target=\'messageFrame\'>\n\t\t<input type=\"hidden\" name=\"hddCitizen\" id=\"hddCitizen\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t<input type=\"hidden\" name=\"hddLegal\" id=\"hddLegal\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=\'hidden\' name=\'Lodger_Disc_Period\' id=\'Lodger_Disc_Period\' value= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=\'hidden\' name=\'Lodger_Disc_Period_unit\' id=\'Lodger_Disc_Period_unit\' value= \"H\">\n\t\t<input type=\'hidden\' name=\'Acc_Disc_Period\' id=\'Acc_Disc_Period\' value= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type=\'hidden\' name=\'Acc_Disc_Period_unit\' id=\'Acc_Disc_Period_unit\' value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" align=\'center\'>\n\t<!--  ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP -->\n\t<!--  ADDED BY SRIDHAR ON 17 FEB 2004 --> \n\n\t<tr>\n\t\t\t<td colspan=7 align=\'left\' class= \"COLUMNHEADER\">&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\t\n\t\t<tr><td colspan=7 class=label height=5></td></tr>\n\t</table>\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" align=\'center\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr>\t\t\n\t\t\t<td colspan=\'7\'>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \t\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \t\t\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t<tr>\t\t\n\t\t\t<td colspan=\'7\'>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="   \n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</table>\n\n\t<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->\n\t<!-- ADDED BY SRIDHAR ON 9th FEB 2004   -->\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t  <script>\n\t\t\t\n\t\t\t\tdocument.AccPersonForm.patient_id.value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\tdocument.AccPersonForm.patient_id.disabled = true;\n\t\t\t\tdocument.AccPersonForm.search.disabled = true;\n\t\t\t\tdocument.getElementById(\'patient_name1\').innerHTML = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t//document.getElementById(\'patient_name\').disabled = true; \n\t\t\t\n\t\t\t\tif(document.AccPersonForm.name_prefix1)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.name_prefix1.value\t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\tdocument.AccPersonForm.name_prefix1.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.name_prefix)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.name_prefix.value = \t\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\tdocument.AccPersonForm.name_prefix.disabled = true;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.AccPersonForm.family_name)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.family_name.value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\tdocument.AccPersonForm.family_name.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bfam)\n\t\t\t\t\tdocument.AccPersonForm.bfam.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.first_name)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.first_name.value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\tdocument.AccPersonForm.first_name.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bf)\n\t\t\t\t\tdocument.AccPersonForm.bf.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.second_name)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.second_name.value\t= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\tdocument.AccPersonForm.second_name.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bs)\n\t\t\t\t\tdocument.AccPersonForm.bs.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.third_name)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.third_name.value\t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\tdocument.AccPersonForm.third_name.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bt)\n\t\t\t\t\tdocument.AccPersonForm.bt.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.name_suffix)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.name_suffix.value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\t\n\t\t\t\t\tdocument.AccPersonForm.name_suffix.disabled = true;\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.name_suffix1)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.name_suffix1.value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\tdocument.AccPersonForm.name_suffix1.disabled = true;\n\t\t\t\t}\n\n\t\t\t\t\n\n\n\t\t\t\tif(document.AccPersonForm.name_prefix_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.name_prefix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\tdocument.AccPersonForm.name_prefix_oth_lang.disabled = true;\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.first_name_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.first_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\tdocument.AccPersonForm.first_name_oth_lang.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bfo)\n\t\t\t\t\tdocument.AccPersonForm.bfo.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.second_name_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.second_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\tdocument.AccPersonForm.second_name_oth_lang.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bso)\n\t\t\t\t\tdocument.AccPersonForm.bso.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.third_name_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.third_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\tdocument.AccPersonForm.third_name_oth_lang.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bto)\n\t\t\t\t\tdocument.AccPersonForm.bto.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.family_name_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.family_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\tdocument.AccPersonForm.family_name_oth_lang.disabled = true;\n\t\t\t\t\tif(document.AccPersonForm.bfamo)\n\t\t\t\t\tdocument.AccPersonForm.bfamo.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.name_suffix_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.name_suffix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\tdocument.AccPersonForm.name_suffix_oth_lang.disabled = true;\n\t\t\t\t}\n\n\t\t\t\tdocument.getElementById(\'patient_name_local_lang1\').innerText \t= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\tdocument.AccPersonForm.patient_name_local_lang.value= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\n\t\t\t\tdocument.AccPersonForm.sex.value \t= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\tdocument.AccPersonForm.sex.disabled = true;\n\n\t\t\t\t//// Alternative for date of bith ...using sql function...\n\t\t\t\tdocument.AccPersonForm.b_age.value\t= \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\t\tdocument.AccPersonForm.b_months.value\t= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\tdocument.AccPersonForm.b_days.value\t= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\n\t\t\t\tif(document.AccPersonForm.b_birth)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.b_birth.disabled = true;\n\t\t\t\t}\n\n\t\t\t\tif(document.getElementById(\'dob\'))\n\t\t\t\t\tdocument.getElementById(\'dob\').disabled = true;\n\n\t\t\t\tif(document.AccPersonForm.b_age)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.b_age.disabled = true;\n\t\t\t\t\tdocument.AccPersonForm.b_months.disabled = true;\n\t\t\t\t\tdocument.AccPersonForm.b_days.disabled = true;\n\t\t\t\t}\n\t\t\t\tdocument.AccPersonForm.national_id_no.value \t= \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\t\tdocument.AccPersonForm.national_id_no.disabled =true;\n\t\t\t\tif(document.AccPersonForm.myKadBtn)\n\t\t\t\t\tdocument.AccPersonForm.myKadBtn.disabled =true;\n\t\t\t\tif(document.AccPersonForm.alt_id1_no)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id1_no.value \t= \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id1_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.alt_id2_no)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id2_no.value \t= \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id2_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.alt_id3_no)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id3_no.value \t= \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id3_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.alt_id4_no)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id4_no.value \t= \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id4_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.alt_id1_exp_date)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id1_exp_date.value \t= \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id1_exp_date.disabled = true;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.AccPersonForm.alt_id2_exp_date)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id2_exp_date.value \t= \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id2_exp_date.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.alt_id3_exp_date)\n\t\t\t\t{\t\n\t\t\t\t\tdocument.AccPersonForm.alt_id3_exp_date.value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id3_exp_date.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.AccPersonForm.alt_id4_exp_date)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.alt_id4_exp_date.value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\t\tdocument.AccPersonForm.alt_id4_exp_date.disabled = true;\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.other_alt_type)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.other_alt_type.value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\t\tdocument.AccPersonForm.other_alt_type.disabled = true;\n\t\t\t\t}\n\n\t\t\t\tif(document.AccPersonForm.other_alt_Id)\n\t\t\t\t{\n\t\t\t\t\tdocument.AccPersonForm.other_alt_Id.value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\tdocument.AccPersonForm.other_alt_Id.disabled = true;\n\t\t\t\t}\n\n\t\t\t\t// Patient contact details popup \n\t\t\t\t// to disable the Contact Detail Button\n\n\t\t\t\tdocument.AccPersonForm.addr_line1.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\t\tdocument.AccPersonForm.addr_line1.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.addr_line2.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\tdocument.AccPersonForm.addr_line2.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.addr_line3.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\tdocument.AccPersonForm.addr_line3.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.addr_line4.value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\tdocument.AccPersonForm.addr_line4.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.res_town_code.value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\t\tdocument.AccPersonForm.res_town_desc.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\n\t\t\t\tdocument.AccPersonForm.res_area_code.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\tdocument.AccPersonForm.res_area_desc.value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\n\t\t\t\tdocument.AccPersonForm.region_code.value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\tdocument.AccPersonForm.region_desc.value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\t\t\n\n\t\t\t\tdocument.AccPersonForm.postal_code.value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\t\t\tdocument.AccPersonForm.r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\n\t\t\t\tdocument.AccPersonForm.country_desc.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\n\t\t\t\tdocument.AccPersonForm.contact1_name.value=\'\';\n\n\t\t\t\tdocument.AccPersonForm.addr2_type.value=\'\';\n\n\t\t\t\tdocument.AccPersonForm.mail_addr_line1.value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_addr_line1.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.mail_addr_line2.value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\t\t\n\t\t\t\tdocument.AccPersonForm.mail_addr_line2.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.mail_addr_line3.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_addr_line3.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.mail_addr_line4.value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_addr_line4.disabled = true;\n\n\t\t\t\tdocument.AccPersonForm.mail_res_town_code.value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_res_town_desc.value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t\n\t\t\t\tdocument.AccPersonForm.mail_res_area_code.value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_res_area_desc.value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\t\t\n\t\t\t\tdocument.AccPersonForm.mail_postal_code.value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\t\t\tdocument.AccPersonForm.m_postal_code_desc.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\n\t\t\t\tdocument.AccPersonForm.mail_region_code.value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_region_desc.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_region_desc.readOnly = true; \n\n\t\t\t\tdocument.AccPersonForm.mail_country_code.value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\tdocument.AccPersonForm.mail_country_desc.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\n\t\t\t\tdocument.AccPersonForm.contact2_name.value=\"\";\n\t\t\t\tdocument.AccPersonForm.contact1_no.value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\t\t\t\tdocument.AccPersonForm.contact2_no.value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\t\t\tdocument.AccPersonForm.email.value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\n\t\t\t\t/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\tdocument.AccPersonForm.alt_addr_line1.value\t\t= \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_addr_line1.disabled\t= true;\n\t\t\t\tdocument.AccPersonForm.alt_addr_line2.value\t\t= \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_addr_line2.disabled\t= true;\n\t\t\t\tdocument.AccPersonForm.alt_addr_line3.value\t\t= \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_addr_line3.disabled\t= true;\n\t\t\t\tdocument.AccPersonForm.alt_addr_line4.value\t\t= \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_addr_line4.disabled\t= true;\n\t\t\t\tdocument.AccPersonForm.alt_area_code.value\t\t= \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_area_desc.value\t\t= \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_town_code.value\t\t= \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_town_desc.value\t\t= \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_postal_code.value\t= \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_postal_desc.value\t= \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_region_code.value\t= \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_region_desc.value\t= \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_country_code.value\t= \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\t\t\tdocument.AccPersonForm.alt_country_desc.value\t= \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\t\t\t/*End*/\n\t\t </script>\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\n\n\t<table align=\'center\' border=\"0\" cellspacing=\"0\" cellpadding=\"4\" width=\"100%\" >\n\t\t<tr><td colspan=10 class=label height=5></td></tr>\n\t\t<tr><td align=\'left\' colspan=\'10\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td></tr> \n\t\t<tr><td colspan=10 class=label height=5></td></tr>\n\t\t<!-- PERIOD FROM -->\n\t\t<tr>\n\t\t<td class=\"label\" width=20% nowrap>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>        \n\t\t<td class=\'fields\' width=30% nowrap>\n\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t<input type=\"text\" id=\'periodfrom\' name=\"period_from\" id=\"period_from\" maxlength=16 size=16 onblur =\"ComparePeriodTime(this,period_to);ValCheckinTime(this,\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\" onKeyPress=\'return(ChkNumberIP(this,event,2))\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"><img  src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].period_from.focus();return showCalendar(\'periodfrom\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\'></img>  \n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="   \n\t\t</td>  \n\t\t<!-- PERIOD TO -->\n\t\t<td class=\"label\" width=25%> ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t<td class=\'fields\' width=25% colspan=\'7\' nowrap>\n\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t<input type=\"text\" id=\'periodto\' name=\"period_to\" id=\"period_to\" maxlength=16 size=16 onblur=\"ComparePeriodTime(period_from,this);\" onKeyPress=\'return(ChkNumberIP(this,event,2))\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].period_to.focus();return showCalendar(\'periodto\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>  \n\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n        </td>\t\t\n\t\t</tr>\n\t\t\t\n\t\t\n\t\t<!-- AUTHORIZED BY -->\n\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t<input type=\"text\" name=\"Authorised_lookup\" id=\"Authorised_lookup\" maxlength=16 size=16 value=\"\" onBlur=\'beforeGetAuthorised(document.forms[0].Authorised_hid,this);enableDisable(this,Authorised_text);\'><input type=button class=\'button\' name=\'search_Authorised\' id=\'search_Authorised\' value=\'?\' onclick=\"getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].Authorised_lookup)\">\n\t\t\t\t\t<input type=\"text\" name=\"Authorised_text\" id=\"Authorised_text\" maxlength=16 size=16 value=\"\" onBlur=\'makeValidString(this);enableDisable(Authorised_lookup,this);\'><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img><input type=hidden name=\"Authorised_hid\" id=\"Authorised_hid\" value=\'\'>\n\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" \n\t\t\t</td>\n\n            <!-- NURSING UNIT -->\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t<td class=\'fields\' colspan=\'7\'>\n\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t<input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" width=\"16\" maxlength=16 size=16  onblur=\"beforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\',\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\');\" ><input type=button class=\'button\' name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\'  value=\'?\' onClick=\"getNursingUnitValue(nursing_unit_desc, \'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\');\" >\n\t\t\t\t<input type=hidden name=\"lodger_nursing_unit\" id=\"lodger_nursing_unit\" width=\"15\" >\n\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t</td>\t\t\n\t\t</tr>\n\n\t\t<!-- REMARKS -->\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t<td class=\'fields\' colspan=\'9\' wrap>\n\t\t\t\t\t<textarea style = \"resize:none\" name=\"remarks\" rows=3  cols=84 maxLength=\'200\' onKeypress=\"return CheckMaxLength(this,200)\" onBlur=\"checkMax(this);\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" >";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</textarea></td>\n\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t<td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td><td colspan=\'8\' ></td>\t\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =" \t\t\t\t\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t<!-- CHECK OUT DATE / TIME --> \n\t\t <tr>\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n            <td class=\'fields\'><input type=\"hidden\" name=\"chk_in_dt_time\" id=\"chk_in_dt_time\" maxlength=16 size=16 onblur =\"dateVal(this)\" value =\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t\t<input type=\"text\" id=\'chkoutdttime\' name=\"chk_out_dt_time\" id=\"chk_out_dt_time\" maxlength=16 size=16 onKeyPress=\'return(ChkNumberIP(this,event,2))\' onblur=\"compareDate(this,document.forms[0].chk_in_dt_time,\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\');\" value =\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].chk_out_dt_time.select();return showCalendar(\'chkoutdttime\', null, \'hh:mm\' );\"/><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n            <td colspan=\'8\' ></td>\n\t\t </tr>  \n\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t<tr><td colspan=\'10\' class=\'button\'></td></tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'3\' class=\'buton\'></td>\n\t\t\t\t<td colspan=\'6\' class=\'fields\'><input type=\'button\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' name=\'release_lodger\' class=\'button\' onClick=\"SubmitPage()\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' name=\'cancel\' class=\'button\' onclick=\'const dialogTag = parent.parent.document.getElementById(\"dialog_tag\"); dialogTag.close();\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t<tr>\n\t\t\t    <td class=\'button\'>&nbsp;</td>\n\t\t\t    <td class=\'button\'>&nbsp;</td>\n\t\t\t    <td class=\'button\'>&nbsp;</td>\n\t\t\t    <td class=\'fields\' colspan=\'7\'>\n\t\t\t\t<input type=\'button\'  value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' name=\'chkIn_Lodger\' class=\'button\' onClick=\"apply()\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' name=\'cancel\' class=\'button\' onclick=\'window.close();\'>\n\t\t\t\t</td>                 \n\t\t\t</tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t\t\t<tr><td colspan=\'10\' class=\'button\'>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" \n\t</table>\n\t\t\t<input type=\"hidden\" name=\"to_chk_in_dt_time\" id=\"to_chk_in_dt_time\" value =\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"> \n\t\t\t<input type=\"hidden\" name=\'Category\' id=\'Category\' value = \"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"> \n\t\t\t<input type=\"hidden\" name=\'encounter_id\' id=\'encounter_id\' value = \"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"> \n\t\t\t<input type=\"hidden\" name=\'locale\' id=\'locale\' value = \"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"> \n\t\t\t<input type=\"hidden\" name=\'lodger_ref_no\' id=\'lodger_ref_no\' value = \"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"> \n\t\t\t<input type=\"hidden\" name=\'pat_id\' id=\'pat_id\' value = \"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">  \n\t\t\t<input type=\'hidden\' name=\'citizenvalue\' id=\'citizenvalue\' value= \"\">\n\t\t\t<input type=\'hidden\' name=\'Dobs\' id=\'Dobs\' value= \"\">\n\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value= \"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value= \"CHECK_IN_ACCMP_PERSON\">\n\t\t\t<input type=\'hidden\' name=\'illegalvalue\' id=\'illegalvalue\' value= \"\">\n\t\t\t<input type=\'hidden\' name=\'label\' id=\'label\' value= \"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t<input type=\'hidden\' name=\'Lodger_Max_RefNo\' id=\'Lodger_Max_RefNo\' value= \"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t<input type=\'hidden\' name=\'Lodger_Next_RefNo\' id=\'Lodger_Next_RefNo\' value= \"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value= \"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value= \"\">\n\t\t\t<input type=\'hidden\' name=\'pLine_Pat_id\' id=\'pLine_Pat_id\' value= \"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value= \"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t<input type=\'hidden\' name=\'maxPatAge\' id=\'maxPatAge\' value= \"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t</form>\n\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n   </body>\n</html>\n\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= null;
	Statement PatIDStmt		= null;
	ResultSet PatIDRS		= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	Statement stmt_opn		= null;
	ResultSet rs_opn		= null;
	Statement AccStmt		= null;
	ResultSet AccRS			= null;
	String facility_id		= (String)session.getValue ( "facility_id" );
	String loginUser		= (String)session.getValue("login_user");
	//String patId_for_accID	= checkForNull(request.getParameter("patId_for_accID"));
	String p_oper_stn_id	= checkForNull(request.getParameter("oper_stn_id"));
	String encounter_id		= checkForNull(request.getParameter("EncounterId"));
	String location_code	= checkForNull(request.getParameter("location_code"));

	String Category = request.getParameter("Category");
	if(Category == null)	Category = "A" ;

	StringBuffer sql			= new StringBuffer();
	String years				= "";
	String months				= "";
	String days					= "";
	String lodger_patient_name	= "";
	String reason_for_stay		= "";
	String alt_long_desc		= "";
	String check_in_date_time	= "";
	String Period_date_time_from= "";
	String Period_date_time_to	= "";
	String Period_dat_dis_tim_fr= "";
	String Period_dat_dis_tim_to= "";
	String authorized_by		= "";  
	String nursing_desc			= "";
	String patientID			= "";
	String rdonly				= "";
	String sysdateTime			= "";
	String lodger_ref_no		= "";			
	String remarks				= "";                			
	String patient_id			= "";
	String lodger_relation_code = "";
	String nameprefix			= "";
	String firstname			= "";
	String secondname			= "";
	String thirdname			= "";
	String familyname			= "";
	String namesuffix			= "";
	String gender				= "";
	String date_of_birth		= "";
	String place_of_birth_code	= "";
	String place_of_birth_desc	= "";
	String citizen				= "";
	String legal				= "";
	String email_id				= "";
	String national_id_no		= "";
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String alt_id4_no			= "";
	String oth_alt_id_no		= ""; 
	String oth_alt_id_type		= "";
	String res_addr_line1		= "";
	String res_addr_line2		= "";
	String res_addr_line3		= "";
	String res_addr_line4		= "";
	String res_town_code		= "";
	String res_town_desc		= "";
	String res_area_code		= "";
	String res_area_desc		= "";
	String res_region_code		= "";
	String res_region_desc		= "";
	String postal_code			= "";
	String postal_code_desc		= "";
	String country_code			= "";
	String mail_addr_line1		= "";
	String mail_addr_line2		= "";
	String mail_addr_line3		= "";
	String mail_addr_line4		= "";
	String mail_country_code	= "";
	String mail_country_desc	= "";
	String mail_town_code		= "";
	String mail_town_desc		= "";
	String mail_area_code		= "";
	String mail_area_desc		= "";
	String mail_region_code		= "";	
	String mail_region_desc		= "";
	String mail_postal_code		= "";
	String mail_postal_code_desc= "";
	String other_tel_no			= "";
	String oth_contact_no		= "";
	String eth_grp				= "";
	String eth_sub_grp			= "";
	String nationality_code		= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String Acc_person_age		= "";
	String name_prefix_loc_lang	= "";
	String first_name_loc_lang	= "";
	String second_name_loc_lang	= "";
	String third_name_loc_lang	= "";
	String family_name_loc_lang	= "";
	String name_suffix_loc_lang	= "";
	String patient_name_loc_lang= "";
	String max_patient_age		= "";
	int IP_param_No_Acc_Persons	= 0;

	/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
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

	String Lodger_Max_RefNo				= checkForNull(request.getParameter("Lodger_Max_RefNo"));
	String Lodger_Next_RefNo			= checkForNull(request.getParameter("Lodger_Next_RefNo"));
	String Lodger_Period				= checkForNull(request.getParameter("Lodger_Period"));
	String Acc_Period					= checkForNull(request.getParameter("Acc_Period"));
	String Acc_Period_unit				= checkForNull(request.getParameter("Acc_Period_unit"));
	String IP_param_No_Acc_Persons_str	= checkForNull(request.getParameter("IP_param_No_Acc_Persons"));

	if(!IP_param_No_Acc_Persons_str.equals(""))
		IP_param_No_Acc_Persons			= Integer.parseInt(IP_param_No_Acc_Persons_str);

	String nationality_long_desc		= "";
	int Available_Acc_persons			= 0;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt					= new java.util.Date();
	String currDate						= dateFormat.format(dt);

	String min = String.valueOf(dt.getMinutes());
	if(min.length() == 1)   min = "0"+min ;
	currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
	check_in_date_time = currDate ;   

	String mode = request.getParameter("mode");
	if(mode == null)
		mode = "insert";

	try
	{
		con = ConnectionManager.getConnection(request);

		if(mode.equals("insert"))
		{
			if(Acc_Period.equals("") || Acc_Period.equals("0"))
			{	
				out.println("<script>alert(getMessage('RENEW_GATE_PASS_NOT_DEF','IP'));parent.window.close();</script>"); 
			}

			StringBuffer AccTotalSql = new StringBuffer();
			AccTotalSql.append("SELECT count(*) FROM IP_LODGER_DETAIL WHERE facility_id = '"+facility_id+"' and PATIENT_ENCOUNTER_ID = '"+encounter_id+"' and CHECK_OUT_YN = 'N' ");

			AccStmt = con.createStatement();
			AccRS = AccStmt.executeQuery( AccTotalSql.toString() );

			if(AccRS!=null)
			{
				if ( AccRS.next() )
				{
					Available_Acc_persons = AccRS.getInt(1);
				}
			}

			if(IP_param_No_Acc_Persons == 0)
			{
				out.println("<script>alert(getMessage('ACC_PERS_PARAM_NOT_DEF','IP'));parent.window.close();</script>");
			}
			else if(IP_param_No_Acc_Persons <= Available_Acc_persons)
			{
				out.println("<script>alert(getMessage('MAX_ACC_PERS_EXCEEDED','IP'));parent.window.close();</script>");
			}

			if(AccRS != null)		AccRS.close();
			if(AccStmt != null)		AccStmt.close();
		}


		/* 	int count=0;
			StringBuffer patIDSql = new StringBuffer();
			patIDSql.append("select a.LODGER_PATIENT_ID LODGER_PATIENT_ID,a.LODGER_REF_NO LODGER_REF_NO, b.REVISED_YN REVISED_YN from IP_LODGER_DETAIL a, IP_LODGER_GATE_PASS b where a.facility_ID='"+facility_id+"' and a.facility_ID=b.facility_ID and a.LODGER_REF_NO=b.LODGER_REF_NO and a.LODGER_PATIENT_ID is not null");

			PatIDStmt = con.createStatement();
			PatIDRS = PatIDStmt.executeQuery( patIDSql.toString() );

			if(PatIDRS != null)
			{
				while( PatIDRS.next() )
				{
					count++;
				}
			}
			if(PatIDRS!=null)PatIDRS.close();
			if(PatIDStmt!=null)PatIDStmt.close();
Monday, June 14, 2010 PE_EXE venkat s**/

			sql.append("select patient_id_length, to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, pat_name_as_multipart_yn,max_patient_age from mp_param ");
			stmt = con.createStatement();
			rs  = stmt.executeQuery(sql.toString());

			if (rs.next())
			{
				sysdateTime	= rs.getString(2);
				max_patient_age	= rs.getString(4);
			}
			
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(Category!=null && !Category.equals("L"))
			{
				
				sql.append("select PATIENT_ID from PR_ENCOUNTER where facility_id='"+facility_id+"' and encounter_id='"+encounter_id+"'" );    
				rs = stmt.executeQuery( sql.toString() );
				if(rs!=null && rs.next())
				{
					patient_id = checkForNull(rs.getString("PATIENT_ID"));
				}
			}
		if(mode.equals("update"))
		{
			lodger_ref_no = request.getParameter("lodger_ref_no") ;
			if(lodger_ref_no.equals("null"))  lodger_ref_no ="" ;

			nursing_desc = request.getParameter("nursing_desc") ;
			if(nursing_desc.equals("null"))  nursing_desc ="" ;

			patientID = request.getParameter("PatID") ;
			if(patientID.equals("null"))  patientID ="" ;

			try
			{
				StringBuffer ExeSQL = new StringBuffer();
				ExeSQL.append(" SELECT a.PATIENT_ENCOUNTER_ID,");
				ExeSQL.append(" a.LODGER_RELATION_CODE,");
				ExeSQL.append(" a.REASON_FOR_STAY_CODE,");
				ExeSQL.append(" a.LODGER_NAME,");
				ExeSQL.append(" to_char(a.check_in_date_time,'dd/mm/rrrr hh24:mi')CHECK_IN_DATE_TIME,");
				ExeSQL.append(" to_char(a.PERIOD_FROM_DATE,'dd/mm/rrrr hh24:mi')PERIOD_FROM_DATE,");
				ExeSQL.append(" to_char(a.PERIOD_TO_DATE,'dd/mm/rrrr hh24:mi')PERIOD_TO_DATE,");
				ExeSQL.append(" a.ATTACHED_TO_INPATIENT_YN,");
				ExeSQL.append(" a.NURSING_UNIT_CODE,a.REMARKS,a.AUTHORISED_BY,a.LODGER_GENDER,");
				ExeSQL.append(" to_char(a.LODGER_DOB,'dd/mm/rrrr')LODGER_DOB,");
				ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),1)years, ");
				ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),2)months, ");
				ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),3)days, ");
				ExeSQL.append(" get_age(a.LODGER_DOB)Acc_person_age,");
				ExeSQL.append(" a.NAME_PREFIX, a.FIRST_NAME, a.SECOND_NAME, a.THIRD_NAME,");
				ExeSQL.append(" a.FAMILY_NAME, a.NAME_SUFFIX,");
				ExeSQL.append(" a.CITIZEN_YN, a.LEGAL_YN,");
				ExeSQL.append(" a.ALT_ID1_TYPE,a.ALT_ID1_NO,");
				ExeSQL.append(" to_char(a.ALT_ID1_EXP_DATE,'dd/mm/rrrr')ALT_ID1_EXP_DATE,");
				ExeSQL.append(" a.ALT_ID2_TYPE,a.ALT_ID2_NO,");
				ExeSQL.append(" to_char(a.ALT_ID2_EXP_DATE,'dd/mm/rrrr')ALT_ID2_EXP_DATE,");
				ExeSQL.append(" a.ALT_ID3_TYPE, a.ALT_ID3_NO,");
				ExeSQL.append(" to_char(a.ALT_ID3_EXP_DATE,'dd/mm/rrrr')ALT_ID3_EXP_DATE,");
				ExeSQL.append(" a.ALT_ID4_TYPE, a.ALT_ID4_NO,");
				ExeSQL.append(" to_char(a.ALT_ID4_EXP_DATE,'dd/mm/rrrr')ALT_ID4_EXP_DATE,");
				ExeSQL.append(" a.OTH_ALT_ID_TYPE OTH_ALT_ID_TYPE,");
				ExeSQL.append(" (CASE WHEN a.OTH_ALT_ID_TYPE IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(a.OTH_ALT_ID_TYPE,'"+locale+"',1)) END) alt_short_desc,");
				ExeSQL.append(" a.OTH_ALT_ID_NO OTH_ALT_ID_NO,");
				ExeSQL.append(" a.LN1_LODGER_ADD, a.LN2_LODGER_ADD,");
				ExeSQL.append(" a.LN3_LODGER_ADD, a.LN4_LODGER_ADD,");
				ExeSQL.append(" a.LODGER_RES_TEL_NUM, a.LODGER_OFF_TEL_NUM,");
				ExeSQL.append(" a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2,");
				ExeSQL.append(" a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4,");
				ExeSQL.append(" a.lodger_patient_id, a.national_id_no,");
				ExeSQL.append(" a.BIRTH_PLACE_CODE BIRTH_PLACE_CODE, (CASE WHEN a.BIRTH_PLACE_CODE IS NOT NULL THEN (mp_get_desc.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"',1)) END) birth_place_desc,");
				ExeSQL.append(" a.ETHNIC_GROUP_CODE, (CASE WHEN a.ETHNIC_GROUP_CODE IS NOT NULL THEN (mp_get_desc.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"',1)) END) ETHNIC_DESCRIPTION,");
				ExeSQL.append(" a.RACE_CODE, (CASE WHEN a.race_code IS NOT NULL THEN (mp_get_desc.mp_race(a.race_code,'"+locale+"',1)) END) RACE_DESCRIPTION,");
				ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, (CASE WHEN a.MAIL_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"',1)) END) MAIL_AREA_DESCRIPTION,");
				ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, (CASE WHEN a.MAIL_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"',1)) END)  MAIL_TOWN_DESCRIPTION,");
				ExeSQL.append(" a.MAIL_REGION_CODE MAIL_REGION_CODE,  (CASE WHEN a.MAIL_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"',1)) END) MAIL_REGION_DESCRIPTION,");
				ExeSQL.append(" a.MAIL_POSTAL_CODE MAIL_POSTAL_CODE, mp_get_desc.mp_postal_code(a.mail_postal_code,'"+locale+"',2)mail_postal_code_desc,");
				ExeSQL.append(" a.MAIL_COUNTRY_CODE, (CASE WHEN a.MAIL_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"',1)) END) MAIL_COUNTRY_DESCRIPTION,");
				ExeSQL.append(" a.RES_AREA_CODE RES_AREA_CODE , (CASE WHEN a.RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"',1)) END) RES_AREA_DESCRIPTION,");
				ExeSQL.append(" a.RES_TOWN_CODE RES_TOWN_CODE, (CASE WHEN a.RES_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"',1)) END) RES_TOWN_DESCRIPTION,");
				ExeSQL.append(" a.RES_REGION_CODE RES_REGION_CODE, (CASE WHEN a.RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.RES_REGION_CODE,'"+locale+"',1)) END) RES_REGION_DESCRIPTION,");
				ExeSQL.append(" a.RES_POSTAL_CODE RES_POSTAL_DESCRIPTION,mp_get_desc.mp_postal_code(a.res_postal_code,'"+locale+"',2)res_postal_code_desc,");
				ExeSQL.append(" a.RES_COUNTRY_CODE, (CASE WHEN a.RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"',1)) END) RES_COUNTRY_DESCRIPTION,");
				ExeSQL.append(" a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
				ExeSQL.append(" a.LODGER_EMAIL,");
				ExeSQL.append(" (CASE WHEN a.NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.NATIONALITY_CODE,'"+locale+"',1)) END) NATIONALITY_DESC, a.NATIONALITY_CODE NATIONALITY_CODE");
				ExeSQL.append("  , NAME_PREFIX_LOC_LANG ");
				ExeSQL.append("  , FIRST_NAME_LOC_LANG ");
				ExeSQL.append("  , SECOND_NAME_LOC_LANG ");
				ExeSQL.append("  , THIRD_NAME_LOC_LANG ");
				ExeSQL.append("  , FAMILY_NAME_LOC_LANG ");
				ExeSQL.append("  , NAME_SUFFIX_LOC_LANG ");
				ExeSQL.append("  , LODGER_NAME_LOC_LANG ");
				ExeSQL.append(" FROM ");
				ExeSQL.append(" ip_lodger_detail a"); 
				ExeSQL.append(" WHERE ");
				ExeSQL.append(" a.facility_id = '"+facility_id+"' AND");
				ExeSQL.append(" a.lodger_ref_no ='"+lodger_ref_no+"' ");

				stmt = con.createStatement();
				rs = stmt.executeQuery(ExeSQL.toString());

			}catch(Exception e) 
			{
				out.println("Error while querying data : "+e.toString());
				e.printStackTrace();
			}
			if(rs!=null)
			{
				if ( rs.next() )
				{
					rdonly = "readonly" ;

					Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
					if(Category.equals("Y"))
						Category = "A" ;
					else
						Category = "L" ;

					years	= checkForNull(rs.getString( "years" ));
					months  = checkForNull(rs.getString( "months" ));
					days    = checkForNull(rs.getString( "days" ));

					encounter_id         = String.valueOf( rs.getLong("patient_encounter_id") );
					if(encounter_id ==null)
						encounter_id ="";

					lodger_relation_code     = rs.getString( "lodger_relation_code" );
					if(lodger_relation_code ==null)
						lodger_relation_code ="";

					reason_for_stay      = rs.getString( "reason_for_stay_code" );
					if(reason_for_stay ==null)
						reason_for_stay ="";
			
					lodger_patient_name  = rs.getString( "lodger_name" );
					if(lodger_patient_name ==null)
						lodger_patient_name ="";                        
					check_in_date_time   = rs.getString( "check_in_date_time" );
					if(check_in_date_time == null)  check_in_date_time = "";


					Period_date_time_from = rs.getString("PERIOD_FROM_DATE"); 
						if(Period_date_time_from == null)	Period_date_time_from = "";


					Period_date_time_to = rs.getString("PERIOD_TO_DATE"); 
						if(	Period_date_time_to == null)	Period_date_time_to = "";

					Period_dat_dis_tim_fr = DateUtils.convertDate(Period_date_time_from,"DMYHM","en",locale);
					Period_dat_dis_tim_to = DateUtils.convertDate(Period_date_time_to,"DMYHM","en",locale);

					remarks   = rs.getString( "REMARKS" );
						if(remarks ==null)     remarks ="";

					if (!remarks.equals("")) 
					{
						if (remarks.length() == 200)
							remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,200);
						else if (remarks.length() > 140)
							remarks = 	remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,remarks.length());
						else if (remarks.length() > 70)
							remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,remarks.length());	
					}
					
					authorized_by        = rs.getString( "authorised_by" );
					if(authorized_by ==null)		authorized_by ="";  

					gender       = rs.getString( "lodger_gender" );
					if(gender==null) gender="";

					Acc_person_age    = rs.getString("Acc_person_age");
					if(Acc_person_age==null) Acc_person_age="";

					date_of_birth    = rs.getString("LODGER_DOB");
					if(date_of_birth==null) date_of_birth = "";

					nameprefix= rs.getString( "NAME_PREFIX" );
					if(nameprefix==null) nameprefix = "";

					firstname= rs.getString( "FIRST_NAME" );
					if(firstname==null) firstname="";

					secondname= rs.getString( "SECOND_NAME");
					if(secondname==null) secondname="";

					thirdname= rs.getString( "THIRD_NAME" );
					if(thirdname==null) thirdname="";

					familyname = rs.getString( "FAMILY_NAME" );
					if(familyname == null) familyname = "";

					namesuffix= rs.getString( "NAME_SUFFIX" );
					if(namesuffix==null) namesuffix="";

					citizen = rs.getString("CITIZEN_YN");
					if(citizen == null) citizen = "";

					legal = rs.getString("LEGAL_YN");
					if(legal == null) legal = "";

					alt_id1_exp_date= rs.getString( "ALT_ID1_EXP_DATE");
					if(alt_id1_exp_date==null) 
						alt_id1_exp_date="";
					else
						alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY","en",locale);

					alt_id2_exp_date= rs.getString( "ALT_ID2_EXP_DATE" );
					if(alt_id2_exp_date==null) 
						alt_id2_exp_date="";
					else
						alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY","en",locale);

					alt_id3_exp_date= rs.getString( "ALT_ID3_EXP_DATE" );
					if(alt_id3_exp_date==null) 
						alt_id3_exp_date="";
					else
						alt_id3_exp_date = DateUtils.convertDate(alt_id3_exp_date,"DMY","en",locale);

					alt_id4_exp_date= rs.getString( "ALT_ID4_EXP_DATE" );
					if(alt_id4_exp_date==null) 
						alt_id4_exp_date="";
					else
						alt_id4_exp_date = DateUtils.convertDate(alt_id4_exp_date,"DMY","en",locale);

					alt_id1_no= rs.getString( "ALT_ID1_NO" );
					if(alt_id1_no==null) alt_id1_no="";

					alt_id2_no	= rs.getString( "ALT_ID2_NO" );
					if(alt_id2_no==null) alt_id2_no="";
					
					alt_id3_no= rs.getString( "ALT_ID3_NO" );
					if(alt_id3_no==null) alt_id3_no="";

					alt_id4_no= rs.getString( "ALT_ID4_NO" );
					if(alt_id4_no==null) alt_id4_no="";

					oth_alt_id_no = rs.getString( "OTH_ALT_ID_NO" );
					if(oth_alt_id_no==null) oth_alt_id_no = "";
					
					oth_alt_id_type = rs.getString( "OTH_ALT_ID_TYPE" );
					if(oth_alt_id_type == null) oth_alt_id_type = "";

					alt_long_desc = rs.getString( "alt_short_desc" );
					if(alt_long_desc == null) alt_long_desc = "";

					place_of_birth_desc = rs.getString( "birth_place_desc" );
					if(place_of_birth_desc == null) place_of_birth_desc = "";

					place_of_birth_code = rs.getString( "BIRTH_PLACE_CODE" );
					if(place_of_birth_code == null) place_of_birth_code = "";

					eth_grp= rs.getString( "ETHNIC_GROUP_CODE" );
					if(eth_grp==null) eth_grp="";

					eth_sub_grp= rs.getString( "RACE_DESCRIPTION" );
					if(eth_sub_grp==null) eth_sub_grp="";

					national_id_no= rs.getString( "NATIONAL_ID_NO" );
					if(national_id_no==null) national_id_no="";

					nationality_code = rs.getString( "NATIONALITY_CODE" );
					if(nationality_code==null) nationality_code="";

					nationality_long_desc = rs.getString( "NATIONALITY_DESC" );
					if(nationality_long_desc  == null) nationality_long_desc  = "";

					res_addr_line1  = rs.getString( "LN1_LODGER_ADD" );
					if(res_addr_line1==null) res_addr_line1="";

					res_addr_line2  = rs.getString( "LN2_LODGER_ADD" );
					if(res_addr_line2==null) res_addr_line2="";

					res_addr_line3  = rs.getString( "LN3_LODGER_ADD" );
					if(res_addr_line3==null) res_addr_line3="";

					res_addr_line4  = rs.getString( "LN4_LODGER_ADD" );
					if(res_addr_line4==null) res_addr_line4="";
			
					res_town_code= rs.getString( "RES_TOWN_CODE" );
					if(res_town_code==null) res_town_code="";

					res_town_desc= rs.getString( "RES_TOWN_DESCRIPTION" );
					if(res_town_desc==null) res_town_desc="";

					res_area_code= rs.getString( "RES_AREA_CODE" );
					if(res_area_code==null) res_area_code="";

					res_area_desc= rs.getString( "RES_AREA_DESCRIPTION" );
					if(res_area_desc==null) res_area_desc="";

					res_region_code		= rs.getString("RES_REGION_CODE");
					if(res_region_code==null) res_region_code="";

					res_region_desc		= rs.getString("RES_REGION_DESCRIPTION");
					if(res_region_desc==null) res_region_desc="";

					postal_code= rs.getString( "RES_POSTAL_DESCRIPTION" );
					if(postal_code==null) postal_code="";

					postal_code_desc= rs.getString( "res_postal_code_desc" );
					if(postal_code_desc==null) postal_code_desc="";

					country_code= rs.getString( "RES_COUNTRY_DESCRIPTION" );
					if(country_code==null) country_code="";
				
					mail_addr_line1= rs.getString( "MAIL_ADDR_LINE1" );
					if(mail_addr_line1==null) mail_addr_line1="";

					mail_addr_line2= rs.getString( "MAIL_ADDR_LINE2" );
					if(mail_addr_line2==null) mail_addr_line2="";

					mail_addr_line3= rs.getString( "MAIL_ADDR_LINE3" );
					if(mail_addr_line3==null) mail_addr_line3="";

					mail_addr_line4= rs.getString( "MAIL_ADDR_LINE4" );
					if(mail_addr_line4==null) mail_addr_line4="";

					mail_town_code		= checkForNull(rs.getString("MAIL_TOWN_CODE"));
					mail_town_desc		= checkForNull(rs.getString("MAIL_TOWN_DESCRIPTION"));
					mail_area_code		= checkForNull(rs.getString("MAIL_AREA_CODE"));
					mail_area_desc		= checkForNull(rs.getString("MAIL_AREA_DESCRIPTION"));
					mail_region_code	= checkForNull(rs.getString("MAIL_REGION_CODE"));
					mail_region_desc	= checkForNull(rs.getString("MAIL_REGION_DESCRIPTION"));
					mail_postal_code	= checkForNull(rs.getString("MAIL_POSTAL_CODE"));
					mail_postal_code_desc	= checkForNull(rs.getString("mail_postal_code_desc"));
					mail_country_code	= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
					mail_country_desc	= checkForNull(rs.getString("MAIL_COUNTRY_DESCRIPTION"));
					oth_contact_no       = checkForNull(rs.getString( "lodger_off_tel_num" ));
					other_tel_no       = checkForNull(rs.getString( "lodger_res_tel_num" ));
					email_id= checkForNull(rs.getString( "LODGER_EMAIL" ));

					/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
					alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
					alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
					alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
					alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
					alt_area_code		= checkForNull(rs.getString("alt_area_code"));
					alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
					alt_town_code		= checkForNull(rs.getString("alt_town_code"));
					alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
					alt_region_code		= checkForNull(rs.getString("alt_region_code"));
					alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
					alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
					alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
					alt_country_code	= checkForNull(rs.getString("alt_country_code"));
					alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
					/*End*/

					name_prefix_loc_lang	= checkForNull(rs.getString("name_prefix_loc_lang"));
					first_name_loc_lang		= checkForNull(rs.getString("first_name_loc_lang"));
					second_name_loc_lang	= checkForNull(rs.getString("second_name_loc_lang"));
					third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
					family_name_loc_lang	= checkForNull(rs.getString("family_name_loc_lang"));
					name_suffix_loc_lang	= checkForNull(rs.getString("name_suffix_loc_lang"));
					patient_name_loc_lang	= checkForNull(rs.getString("LODGER_NAME_LOC_LANG"));
				}//E.o RS
			}// E.o RS !null
		}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(citizen));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(legal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Lodger_Period));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Acc_Period));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Acc_Period_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	if(mode.equals("insert"))
		{	
            _bw.write(_wl_block15Bytes, _wl_block15);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf("CHECK_IN_ACCMP_PERSON")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block19Bytes, _wl_block19);
	}
		else
		{	
            _bw.write(_wl_block20Bytes, _wl_block20);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf("CHECK_IN_ACCMP_PERSON")},{ weblogic.utils.StringUtils.valueOf("lodger_relation_code"), weblogic.utils.StringUtils.valueOf(lodger_relation_code
                        )},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("readonly_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[0]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block19Bytes, _wl_block19);
	}
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	try
	{
		if(!mode.equals("insert"))
		{	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(lodger_patient_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(years));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(months));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(days));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alt_id3_exp_date));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_id4_exp_date));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(res_addr_line1));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(res_addr_line2));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(res_addr_line3));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(res_addr_line4));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(postal_code_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(mail_town_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(mail_town_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mail_area_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(mail_area_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mail_postal_code_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(other_tel_no));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block101Bytes, _wl_block101);
	}
	}catch(Exception eass) 
	{
		out.println("Error while assigning data : "+eass.toString());
		eass.printStackTrace();
	}
	
            _bw.write(_wl_block102Bytes, _wl_block102);
  String label =""; 
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
	if(mode.equals("insert"))
		{	
			String sysdateTime_display = DateUtils.convertDate(sysdateTime,"DMYHM","en",localeName);
	
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(sysdateTime_display));
            _bw.write(_wl_block108Bytes, _wl_block108);
	}
		else
		{  
			out.println("<b>");
			out.println(Period_dat_dis_tim_fr); 
			out.println("</b>");
		} 
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
	if(mode.equals("insert"))
		{	
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(Period_date_time_to));
            _bw.write(_wl_block112Bytes, _wl_block112);
	}
		else
		{
			if(mode.equals("update"))
			{
				out.println("<b>");
				out.println(Period_dat_dis_tim_to) ;
				out.println("</b>");
			}
		}	
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
if(mode.equals("insert"))
				{
            _bw.write(_wl_block115Bytes, _wl_block115);
	}
				else
				{
					out.println("<b>");
					out.println( authorized_by ) ;	
					out.println("</b>");
				}
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
if(mode.equals("insert"))
			{
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
	}
			else
			{
				out.println("<b>");
				out.println(nursing_desc);	
				out.println("</b>");
			}
		
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
if(mode.equals("insert"))
				{
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block126Bytes, _wl_block126);
}
				else
				{
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block129Bytes, _wl_block129);
	if(mode.equals("update"))	
		{	
			String currDate_display = DateUtils.convertDate(currDate,"DMYHM","en",localeName);	
	
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(label));

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(check_in_date_time));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(currDate_display));
            _bw.write(_wl_block134Bytes, _wl_block134);
	}	
            _bw.write(_wl_block135Bytes, _wl_block135);
	if(mode.equals("update"))
		{	
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels")));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block138Bytes, _wl_block138);
	}
		else
		{	
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block141Bytes, _wl_block141);
	}	
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(Category));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(lodger_ref_no));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(label));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(Lodger_Max_RefNo));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(Lodger_Next_RefNo));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(max_patient_age));
            _bw.write(_wl_block156Bytes, _wl_block156);
		

	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if (rs != null)			rs.close();
			if (stmt != null)		stmt.close();
			if (rs_opn != null)		rs_opn.close();
			if (stmt_opn != null)	stmt_opn.close();
			if (PatIDRS != null)	PatIDRS.close();
			if (PatIDStmt != null)	PatIDStmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception in tryCatch : "+ e.toString());
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	}	
            _bw.write(_wl_block157Bytes, _wl_block157);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AccompanyingPersonDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.staydetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodto.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.checkoutdatetime.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
