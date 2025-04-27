package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import com.ehis.util.*;
import java.text.*;

public final class __checkinlodgerdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CheckinLodgerDetail.jsp", 1742376775217L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n    \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script src=\'../../eCommon/js/CommonCalendar.js\' language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../js/CheckinLodger.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<script> \n\n</script> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</head>\n\n<body onLoad= \'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'LodgerForm\' id=\'LodgerForm\' method=\'post\' action=\'../../servlet/eIP.BookLodgerServlet\' target=\'messageFrame\'>\n\t<input type=\"hidden\" name=\"hddCitizen\" id=\"hddCitizen\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >\n\t<input type=\"hidden\" name=\"hddLegal\" id=\"hddLegal\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >\n\t<input type=\'hidden\' name=\'Lodger_Disc_Period\' id=\'Lodger_Disc_Period\' value= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\'hidden\' name=\'Lodger_Disc_Period_unit\' id=\'Lodger_Disc_Period_unit\' value= \"H\">\n\t<input type=\'hidden\' name=\'Acc_Disc_Period\' id=\'Acc_Disc_Period\' value= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\'hidden\' name=\'Acc_Disc_Period_unit\' id=\'Acc_Disc_Period_unit\' value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="value= \"CHECK_IN_LODGER\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="value= \"CHECK_OUT_LODGER\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</tr>\n\n<!-- ###### ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP ####### -->\n<tr>\n\t<td colspan=\'4\'>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \t\t\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\t\t\tdocument.forms[0].patient_id.value\t\t= \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\tcheckPatient(document.forms[0].patient_id)\n\t\t\tdocument.forms[0].patient_id.disabled\t= true;\n\t\t\tdocument.forms[0].search.disabled\t\t= true;\n\t\t\t//setTimeout(\'disman()\',1000);\n\t   \t\tdocument.LodgerForm.race_desc.disabled = true;\n\t\t\tdocument.LodgerForm.race_desc_id.disabled = true;\n\t\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="   \n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</td>  \n</tr>   \n</table>\n\n\n\n<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n  <script>\n\n\t\tdocument.LodgerForm.patient_id.value \t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\tdocument.LodgerForm.patient_id.disabled = true;\n\t\tdocument.LodgerForm.search.disabled\t\t= true;\n\t\t\n\t\tdocument.getElementById(\'patient_name1\').innerHTML\t= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\n\t\tdocument.getElementById(\'patient_name1\').disabled\t= true;\n\n\t\t/*Friday, July 03, 2009 modified for IN012078*/\n\t\t/*if(document.LodgerForm.name_prefix1)\n\t\t{\n\t\t\n\t\t\tdocument.LodgerForm.name_prefix1.value \t\t= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\tdocument.LodgerForm.name_prefix1.disabled\t= true;\n\t\t}*/\n\t\tif(document.LodgerForm.name_prefix)\n\t\t{\n\t\t\n\t\t\tdocument.LodgerForm.name_prefix.value \t\t= \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\tdocument.LodgerForm.name_prefix.disabled\t= true;\n\t\t}\n\t\t\n\t\t\n\t\tif(document.LodgerForm.family_name)\n\t\t{\n\t\tdocument.LodgerForm.family_name.value \t\t= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\tdocument.LodgerForm.family_name.disabled\t= true;\n\t\tif(document.LodgerForm.bfam)\n\t\tdocument.LodgerForm.bfam.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t\n\t\t\n\t\t}\n\n\t\tif(document.LodgerForm.first_name)\n\t\t{\n\t\t\tdocument.LodgerForm.first_name.value \t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\tdocument.LodgerForm.first_name.disabled = true;\n\t\t\tif(document.LodgerForm.bf)\n\t\t\tdocument.LodgerForm.bf.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\tif(document.LodgerForm.second_name)\n\t\t{\n\t\t\tdocument.LodgerForm.second_name.value \t= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\tdocument.LodgerForm.second_name.disabled= true;\n\t\t\tif(document.LodgerForm.bs)\n\t\t\tdocument.LodgerForm.bs.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\tif(document.LodgerForm.third_name)\n\t\t{\n\t\t\tdocument.LodgerForm.third_name.value \t= \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\tdocument.LodgerForm.third_name.disabled = true;\n\t\t\tif(document.LodgerForm.bt)\n\t\t\tdocument.LodgerForm.bt.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\t/*Friday, July 03, 2009 modified for IN012078*/\n\t\t/*if(document.LodgerForm.name_suffix1)\n\t\t{\n\t\t\n\t\t\tdocument.LodgerForm.name_suffix1.value \t= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\tdocument.LodgerForm.name_suffix1.disabled= true;\n\t\t}*/\n\n\t\tif(document.LodgerForm.name_suffix)\n\t\t{\n\t\t\n\t\t\tdocument.LodgerForm.name_suffix.value \t= \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\tdocument.LodgerForm.name_suffix.disabled= true;\n\t\t}\n\t\t\n\n\n\t\tif(document.LodgerForm.name_prefix_oth_lang)\n\t    {\n\t\t\tdocument.LodgerForm.name_prefix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\tdocument.LodgerForm.name_prefix_oth_lang.disabled = true;\n\t\t}\n\n\t\tif(document.LodgerForm.first_name_oth_lang)\n\t    {\n\t\t\tdocument.LodgerForm.first_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\tdocument.LodgerForm.first_name_oth_lang.disabled = true;\n\t\t\tif(document.LodgerForm.bfo)\n\t\t\tdocument.LodgerForm.bfo.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\tif(document.LodgerForm.second_name_oth_lang)\n\t    {\n\t\t\tdocument.LodgerForm.second_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\tdocument.LodgerForm.second_name_oth_lang.disabled = true;\n\t\t\tif(document.LodgerForm.bso)\n\t\t\tdocument.LodgerForm.bso.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\tif(document.LodgerForm.third_name_oth_lang)\n\t    {\n\t\t\tdocument.LodgerForm.third_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\tdocument.LodgerForm.third_name_oth_lang.disabled = true;\n\t\t\tif(document.LodgerForm.bto)\n\t\t\tdocument.LodgerForm.bto.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\tif(document.LodgerForm.family_name_oth_lang)\n\t    {\n\t\t\tdocument.LodgerForm.family_name_oth_lang.value \t= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\tdocument.LodgerForm.family_name_oth_lang.disabled = true;\n\t\t\tif(document.LodgerForm.bfamo)\n\t\t\tdocument.LodgerForm.bfamo.disabled\t= true;//added by  munisekhar  for [IN:046231]\n\t\t}\n\n\t\tif(document.LodgerForm.name_suffix_oth_lang)\n\t    {\n\t\t\tdocument.LodgerForm.name_suffix_oth_lang.value \t= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tdocument.LodgerForm.name_suffix_oth_lang.disabled = true;\n\t\t}\n\n\t\tdocument.getElementById(\'patient_name_local_lang1\').innerText \t= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\tdocument.LodgerForm.patient_name_local_lang.value \t= \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\n\t\tdocument.LodgerForm.sex.value \t\t= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\tdocument.LodgerForm.sex.disabled\t= true;\n\n\t\tdocument.LodgerForm.date_of_birth.value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\tdocument.LodgerForm.date_of_birth.onblur();\n\t\tdocument.LodgerForm.date_of_birth.disabled = true;\n\n\t\tdocument.LodgerForm.b_birth.disabled\t= true;\n\t\tdocument.getElementById(\'dob\').disabled\t\t\t\t= true;\n\t\tdocument.LodgerForm.b_age.disabled\t\t= true;\n\t\tdocument.LodgerForm.b_months.disabled\t= true;\n\t\tdocument.LodgerForm.b_days.disabled\t\t= true;\n\n\t\tdocument.LodgerForm.Birth_place_code.value \t= \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\n\t\tif((document.LodgerForm.Birth_place_code.value == null) || (document.LodgerForm.Birth_place_code.value == \"\"))\n\t\t{\t\n\t\t\tdocument.LodgerForm.place_of_birth.value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t}else\n\t\tdocument.LodgerForm.birth_place.value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\n\t\tdocument.LodgerForm.birth_place.disabled\t= true;\n\t\tdocument.LodgerForm.place_of_birth.disabled\t= true;\n\n\t\tdocument.LodgerForm.nationality_code1.value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\tdocument.LodgerForm.nationality_desc.value\t= \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\tdocument.LodgerForm.nationality_desc.disabled= true;\n\t\tdocument.LodgerForm.nationality_id.disabled = true;\n\n\t\tdocument.LodgerForm.national_id_no.value \t= \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\tdocument.LodgerForm.national_id_no.disabled = true;\n\n\t\tif(document.LodgerForm.myKadBtn)\n\t\t\tdocument.LodgerForm.myKadBtn.disabled = true;\n\n\t\tif(document.LodgerForm.alt_id1_no)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id1_no.value \t= \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\tdocument.LodgerForm.alt_id1_no.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.alt_id2_no)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id2_no.value \t= \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\tdocument.LodgerForm.alt_id2_no.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.alt_id3_no)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id3_no.value \t= \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\tdocument.LodgerForm.alt_id3_no.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.alt_id4_no)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id4_no.value \t= \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\tdocument.LodgerForm.alt_id4_no.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.alt_id1_exp_date)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id1_exp_date.value \t= \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\tdocument.LodgerForm.alt_id1_exp_date.disabled = true;\n\t\t}\n\t\t\n\t\tif(document.LodgerForm.alt_id2_exp_date)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id2_exp_date.value \t= \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\tdocument.LodgerForm.alt_id2_exp_date.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.alt_id3_exp_date)\n\t\t{\t\n\t\t\tdocument.LodgerForm.alt_id3_exp_date.value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\tdocument.LodgerForm.alt_id3_exp_date.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.alt_id4_exp_date)\n\t\t{\n\t\t\tdocument.LodgerForm.alt_id4_exp_date.value = \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\tdocument.LodgerForm.alt_id4_exp_date.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.other_alt_type)\n\t\t{\n\t\t\tdocument.LodgerForm.other_alt_type.value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\tdocument.LodgerForm.other_alt_type.disabled = true;\n\t\t}\n\t\tif(document.LodgerForm.other_alt_Id)\n\t\t{\n\t\t\tdocument.LodgerForm.other_alt_Id.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\tdocument.LodgerForm.other_alt_Id.disabled = true;\n\t\t}\n\n\t\t/*\n\t\tvar obj =document.forms[0].race_code;\n\t\tvar opt= document.createElement(\'Option\');\n\t\topt.text=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"; \n\t\tobj.add(opt)\n\t\topt.selected = true;\n\t\tdocument.LodgerForm.race_code.disabled = true;\n\t\t*/\n\n\t\tif(document.forms[0].race_desc)\n\t\t{\n \t\t\tdocument.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\tdocument.LodgerForm.race_desc.disabled = true;\n\t\t\tdocument.LodgerForm.race_desc_id.disabled = true;\n\t\t}\n\n/*\t\t// For populating Ethnicity...\n\t\tvar n = document.forms[0].ethnic_group.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\tdocument.forms[0].ethnic_group.remove(\"ethnic_group\");\n\t\tvar Ethobj =document.forms[0].ethnic_group;\n\t\tvar Ethopt= document.createElement(\'Option\');\n\t\tEthopt.text=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"; \n\t\tEthobj.add(Ethopt)\n\t\tEthobj.selected = true;\n*/\n\t\tdocument.LodgerForm.ethnic_group.value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\tdocument.LodgerForm.ethnic_group.disabled = true;\n\n\t\tif(document.LodgerForm.hddCitizen.value == \"Y\")\n\t\t\tdocument.LodgerForm.citizen_yn[0].checked = true;\n\t\telse\n\t\t\tdocument.LodgerForm.citizen_yn[1].checked = true;\n\n\t\tdocument.LodgerForm.citizen_yn[0].disabled = true;\t\t\n\t\tdocument.LodgerForm.citizen_yn[1].disabled = true;\t\t\n\n\t\tif(document.LodgerForm.hddLegal.value == \"Y\")\n\t\t\tdocument.LodgerForm.legal_yn[0].checked = true;\n\t\telse\n\t\t\tdocument.LodgerForm.legal_yn[1].checked = true;\n\n\t\tdocument.LodgerForm.legal_yn[0].disabled = true;\t\t\n\t\tdocument.LodgerForm.legal_yn[1].disabled = true;\t\t\n\n\t\t// Patient contact details popup \n\t\t// to disable the Contact Detail Button\n\t\tdocument.LodgerForm.addr_line1.value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\t\tdocument.LodgerForm.addr_line1.disabled = true;\n\n\t\tdocument.LodgerForm.addr_line2.value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\tdocument.LodgerForm.addr_line2.disabled = true;\n\n\t\tdocument.LodgerForm.addr_line3.value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\tdocument.LodgerForm.addr_line3.disabled = true;\n\n\t\tdocument.LodgerForm.addr_line4.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\tdocument.LodgerForm.addr_line4.disabled = true;\n\n\t\tdocument.LodgerForm.res_town_code.value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\tdocument.LodgerForm.res_town_desc.value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\n\t\tdocument.LodgerForm.res_area_code.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\tdocument.LodgerForm.res_area_desc.value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\n\t\tdocument.LodgerForm.region_code.value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\tdocument.LodgerForm.region_desc.value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\t\t\n\n\t\tdocument.LodgerForm.postal_code.value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\tdocument.LodgerForm.r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\n\t\tdocument.LodgerForm.country_desc.value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\n\t\tdocument.LodgerForm.contact1_name.value=\'\';\n\n\t\tdocument.LodgerForm.addr2_type.value=\'\';\n\n\t\tdocument.LodgerForm.mail_addr_line1.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\t\tdocument.LodgerForm.mail_addr_line1.disabled = true;\n\n\t\tdocument.LodgerForm.mail_addr_line2.value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\tdocument.LodgerForm.mail_addr_line2.disabled = true;\n\n\t\tdocument.LodgerForm.mail_addr_line3.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\tdocument.LodgerForm.mail_addr_line3.disabled = true;\n\n\t\tdocument.LodgerForm.mail_addr_line4.value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\tdocument.LodgerForm.mail_addr_line4.disabled = true;\n\n\t\tdocument.LodgerForm.mail_res_town_code.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\tdocument.LodgerForm.mail_res_town_desc.value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\n\t\tdocument.LodgerForm.mail_res_area_code.value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\tdocument.LodgerForm.mail_res_area_desc.value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\n\t\tdocument.LodgerForm.mail_postal_code.value\t\t= \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\tdocument.LodgerForm.m_postal_code_desc.value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\tdocument.LodgerForm.mail_region_code.value\t\t= \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\tdocument.LodgerForm.mail_region_desc.value\t\t= \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\tdocument.LodgerForm.mail_region_desc.readOnly\t= true; \n\n\t\tdocument.LodgerForm.mail_country_code.value\t= \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\tdocument.LodgerForm.mail_country_desc.value\t= \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\n\t\tdocument.LodgerForm.contact2_name.value\t= \"\";\n\t\tdocument.LodgerForm.contact1_no.value\t= \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\t\t\n\t\tdocument.LodgerForm.contact2_no.value\t= \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\tdocument.LodgerForm.email.value\t\t\t= \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\n\t\t/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\tdocument.LodgerForm.alt_addr_line1.value\t= \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\tdocument.LodgerForm.alt_addr_line1.disabled = true;\n\t\tdocument.LodgerForm.alt_addr_line2.value\t= \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\tdocument.LodgerForm.alt_addr_line2.disabled = true;\n\t\tdocument.LodgerForm.alt_addr_line3.value\t= \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\tdocument.LodgerForm.alt_addr_line3.disabled = true;\n\t\tdocument.LodgerForm.alt_addr_line4.value\t= \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\tdocument.LodgerForm.alt_addr_line4.disabled = true;\n\t\tdocument.LodgerForm.alt_area_code.value\t\t= \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\tdocument.LodgerForm.alt_area_desc.value\t\t= \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\tdocument.LodgerForm.alt_town_code.value\t\t= \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\tdocument.LodgerForm.alt_town_desc.value\t\t= \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\tdocument.LodgerForm.alt_postal_code.value\t= \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\tdocument.LodgerForm.alt_postal_desc.value\t= \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\tdocument.LodgerForm.alt_region_code.value\t= \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\tdocument.LodgerForm.alt_region_desc.value\t= \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\n\t\tdocument.LodgerForm.alt_country_code.value\t= \"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\t\tdocument.LodgerForm.alt_country_desc.value\t= \"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t/*End*/\n </script>\n\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n  <script>\n\t /* if(parent.frames[0].document.LodgerForm.race_required_yn.value == \'Y\')\n\t\t{\n\t\n\t\tif(parent.frames[0].document.LodgerForm.hddCitizen==\'Y\')\n\t\t{\n\t\t\t\tdocument.getElementById(\'eth_gif\').style.visibility=\'visible\';\n\t\t}\n\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'eth_gif\').style.visibility=\'hidden\';\n\n\t\t\t}\n\t\t}\n\t\telse\n\t{\n\t\t///alert(\'11\')\n\t\tdocument.getElementById(\'eth_gif\').style.visibility=\'hidden\';\n\n\t} */ \n\t\t\tdocument.LodgerForm.race_desc.disabled = true;\n\t\t\tdocument.LodgerForm.race_desc_id.disabled = true;\n\t\n\n  </script>\n\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"4\" width=\"100%\" align=\'center\'>\n\t<tr><td colspan=\'4\' align=\'left\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td></tr> \n\t<tr>\n    ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\n</tr>\n\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t    <td class=\'fields\' nowrap>\n\t\t<input type=\"text\" id=\'periodfrom\' name=\"period_from\" id=\"period_from\" maxlength=16 size=16 onblur =\"ComparePeriodTime(this,period_to);ValCheckinTime(this,\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\')\" onKeyPress=\'return(ChkNumberIP(this,event,2))\'  value =\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].period_from.focus();return showCalendar(\'periodfrom\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>  \n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="   \n</td>  \n<td class=\"label\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t        <td class=\'fields\' nowrap><input type=\"text\" id=\'periodto\' name=\"period_to\" id=\"period_to\" maxlength=16 size=16 onblur=\"ComparePeriodTime(period_from,this);\" onKeyPress=\'return(ChkNumberIP(this,event,2))\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].period_to.focus();return showCalendar(\'periodto\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>  \n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n</td>\n</tr>\n\n<!-- NURSING UNIT -->\n<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\t\n\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t    <td class=\'fields\' nowrap>\n\t\t<input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" maxlength=16 size=16  onblur=\"beforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\',\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\');\" ><input type=button class=button name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\'  value=\'?\' onClick=\"getNursingUnitValue(nursing_unit_desc, \'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\');\" >\n\t\t<input type=hidden name=\"lodger_nursing_unit\" id=\"lodger_nursing_unit\">\n\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n</td>\n\n<!-- AUTHORIZED BY -->\n\n<td class=\"label\" >";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\n\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n            <td class=\'fields\' nowrap>\n\t\t\t<input type=\"text\" name=\"authorised_by\" id=\"authorised_by\" maxlength=16 size=16 value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" onBlur=\'makeValidString(this);\'><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" \n\t</td>\n</tr>\n\n<!-- REMARKS -->\n<tr>\n\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t<td class=\'fields\' wrap colspan=\'2\'><textarea style=\"resize:none\" name=\"remarks\" rows=3  cols=70 maxLength=\'200\' onKeypress=\"return CheckMaxLength(this,200)\" onBlur=\"checkMax(this);\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =">";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</textarea>\n\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t<td class=\'QUERYDATA\' colspan=\'2\'>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\t\t\t\n\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t</td>\t\t\n        <td class=\'label\'></td>\n</tr>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n<!-- CHECK OUT DATE / TIME -->\n\t <tr> \n\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t<input type=\"hidden\" name=\"chk_in_dt_time\" id=\"chk_in_dt_time\" maxlength=16 size=16 onblur =\"dateVal(this)\" value =\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t<td class=\'fields\' nowrap><input type=\"text\" id=\'chkoutdttime\' name=\"chk_out_dt_time\" id=\"chk_out_dt_time\" maxlength=16 size=16 onKeyPress=\'return(ChkNumberIP(this,event,2))\' onblur=\"compareDate(this,document.forms[0].chk_in_dt_time,\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\');\" value =\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" ><img  src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].chk_out_dt_time.select();return showCalendar(\'chkoutdttime\', null, \'hh:mm\' );\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t</tr>  \n\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t<!-- <tr><td  class=\'button\'></td></tr> -->\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td  class=\'fields\' nowrap><input type=\'button\' value=\'Release Lodger\' name=\'release_lodger\' id=\'release_lodger\' class=\'button\' onClick=\"SubmitPage()\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' name=\'cancel\' class=\'button\' onclick=\'window.close();\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t<tr>\n\t\t<td  class=\'button\'>&nbsp;</td>\n\t\t<td  class=\'button\'>&nbsp;</td>\n\t\t<td  class=\'button\'>&nbsp;</td>\n\t\t<td  class=\'fields\' nowrap><input type=\'button\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' name=\'chkIn_Lodger\' class=\'button\' onClick=\"apply()\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' name=\'cancel\' class=\'button\' onclick=\'parent.parent.document.getElementById(\"dialog_tag\").close();\'>\n\t\t</td>\n\t</tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'></td></tr>\n\t\t<tr><td  class=\'button\' colspan=\'4\'>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" \n</table>\n\t\t<input type=\"hidden\" name=\'Category\' id=\'Category\' value = \"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"> \n\t\t<input type=\"hidden\" name=\'locale\' id=\'locale\' value = \"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"> \n\t\t<input type=\"hidden\" name=\'lodger_ref_no\' id=\'lodger_ref_no\' value = \"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"> \n\t\t<input type=\"hidden\" name=\'pat_id\' id=\'pat_id\' value = \"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">  \n\t\t<input type=\"hidden\" name=\'encounter_id\' id=\'encounter_id\' value = \"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"> \n\t\t<input type=\"hidden\" name=\"to_chk_in_dt_time\" id=\"to_chk_in_dt_time\" maxlength=16 size=16 onblur =\"dateVal(this)\" value =\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"> \n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value= \"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t<input type=\'hidden\' name=\'label\' id=\'label\' value= \"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t<input type=\'hidden\' name=\'pLine_Pat_id\' id=\'pLine_Pat_id\' value= \"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t<input type=\'hidden\' name=\'Lodger_Max_RefNo\' id=\'Lodger_Max_RefNo\' value= \"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t<input type=\'hidden\' name=\'Lodger_Next_RefNo\' id=\'Lodger_Next_RefNo\' value= \"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value= \"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t<input type=\'hidden\' name=\'citizenvalue\' id=\'citizenvalue\' value= \"\">\n\t\t<input type=\'hidden\' name=\'illegalvalue\' id=\'illegalvalue\' value= \"\">\n\t</form>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n   </body>\n</html>\n\n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

	// By Sridhar R  added on 3/15/2005 ... to handle NullPointerException...
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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

/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckInLodger && CheckOutLodger
/// Developer		:	SRIDHAR R
/// Created on		:	30 JULY 2004
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String openWindow = checkForNull(request.getParameter("openWindow"));
	if(openWindow.equals("NO"))
	{
		out.println("<script>parent.window.close();</script>");
	}
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	//Statement PatIDStmt		= null;
	//ResultSet PatIDRS		= null;			
	Statement stmt			= null;
	ResultSet rs			= null;
	Statement stmt_opn		= null;
	ResultSet rs_opn		= null;
	Statement ParamStmt		= null;
	ResultSet ParamRS		= null;
	
	String locale			= (String)session.getAttribute("LOCALE");
	  
	String facility_id		= (String)session.getValue ( "facility_id" ) ;
	String loginUser		= (String)session.getValue("login_user");
	String p_oper_stn_id	= checkForNull(request.getParameter("oper_stn_id"));
	String encounter_id		= checkForNull(request.getParameter("EncounterId"));
 	
	String Category			= request.getParameter("Category");
	if(Category == null)  Category = "L" ;

	String mode = request.getParameter("mode") ;
	if( mode == null )  mode = "insert" ;

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
	String race_desc			= "";
	String ethnic_description	= "";
	String nationality_code		= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String nationality_long_desc= "";
	String Lodger_Max_RefNo		= "";
	String Lodger_Next_RefNo	= "";
	String Lodger_Period		= "";	
	String Acc_Period			= "";
	String Acc_Period_unit		= "";
	String name_prefix_loc_lang	= "";
	String first_name_loc_lang	= "";
	String second_name_loc_lang	= "";
	String third_name_loc_lang	= "";
	String family_name_loc_lang	= "";
	String name_suffix_loc_lang	= "";
	String lodger_name_loc_lang = "";

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

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	String currDate = dateFormat.format( dt ) ;
	String min = String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;
	currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
	check_in_date_time = currDate ;   

	String patientId = checkForNull(request.getParameter("patientId"));

	try
	{
		con						= ConnectionManager.getConnection(request);
		StringBuffer paramSql	= new StringBuffer();
		paramSql.append(" select to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate, LODGER_MAX_SRL_NO, LODGER_NEXT_SRL_NO, MAX_STAY_OF_LODGER_AFTER_DISC, DFLT_GATE_PASS_PERIOD, DFLT_GATE_PASS_UNIT from ip_param where facility_ID='"+facility_id+"' ");
		ParamStmt				= con.createStatement();
		ParamRS					= ParamStmt.executeQuery( paramSql.toString() );

		if(ParamRS!=null)
		{
			if ( ParamRS.next() )
			{
				sysdateTime			= ParamRS.getString("sdate");
				Lodger_Max_RefNo	= checkForNull(ParamRS.getString("LODGER_MAX_SRL_NO"));
				Lodger_Next_RefNo	= checkForNull(ParamRS.getString("LODGER_NEXT_SRL_NO"));
				Lodger_Period		= checkForNull(ParamRS.getString("MAX_STAY_OF_LODGER_AFTER_DISC"));
				Acc_Period			= checkForNull(ParamRS.getString("DFLT_GATE_PASS_PERIOD"));
				Acc_Period_unit		= checkForNull(ParamRS.getString("DFLT_GATE_PASS_UNIT"));
			}
		}

			if(ParamStmt != null) ParamStmt.close();
			if(ParamRS != null) ParamRS.close();
/* Thursday, June 10, 2010 venkats PE_EXE 
		int count=0;
		StringBuffer patIDSql = new StringBuffer();
		patIDSql.append(" select a.lodger_patient_id lodger_patient_id,a.lodger_ref_no lodger_ref_no, b.revised_yn revised_yn from IP_LODGER_DETAIL a, IP_LODGER_GATE_PASS b where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id and a.lodger_ref_no=b.lodger_ref_no and a.lodger_patient_id is not null ");
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
	*/
if( mode.equals("update") )  
{
	lodger_ref_no	= checkForNull(request.getParameter("lodger_ref_no"));
	nursing_desc	= checkForNull(request.getParameter("nursing_desc"));
	patientID		= checkForNull(request.getParameter("PatID"));
	
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
	ExeSQL.append(" get_age(a.LODGER_DOB) DOB, ");
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
	ExeSQL.append(" a.RACE_CODE, ");
	ExeSQL.append("(CASE WHEN a.race_code IS NOT NULL THEN (mp_get_desc.mp_race(a.race_code,'"+locale+"',1)) END) RACE_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, (CASE WHEN a.MAIL_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"',1)) END) MAIL_AREA_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, (CASE WHEN a.MAIL_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"',1)) END) MAIL_TOWN_DESCRIPTION,");
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
	ExeSQL.append(" IP_LODGER_DETAIL a");
	ExeSQL.append(" WHERE ");
	ExeSQL.append(" a.facility_id = '"+facility_id+"' AND");
	ExeSQL.append(" a.lodger_ref_no ='"+lodger_ref_no+"' "); 
	
	stmt = con.createStatement();
	rs = stmt.executeQuery(ExeSQL.toString());

	if(rs!=null && rs.next())
	{
		rdonly = "readonly" ;

		Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
		if(Category.equals("Y"))
			Category = "A" ;
		else
			Category = "L" ;

		years	= rs.getString( "years" );
			if(years ==null)	years ="";
		months  = rs.getString( "months" );
			if(months ==null)	months ="";
		days    = rs.getString( "days" );
			if(days ==null)	days ="";

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

			authorized_by      = rs.getString( "authorised_by" );
			if(authorized_by ==null)		authorized_by ="";  

			gender       = rs.getString( "lodger_gender" );
			if(gender==null) gender="";

			date_of_birth    = rs.getString( "LODGER_DOB" );
			if(date_of_birth==null) 
				date_of_birth = "";
			else
				date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",locale);

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

			race_desc= rs.getString( "RACE_DESCRIPTION" );
			if(race_desc==null) race_desc="";

			ethnic_description= rs.getString( "ETHNIC_DESCRIPTION" );
			if(ethnic_description==null) ethnic_description="";

			national_id_no= rs.getString( "NATIONAL_ID_NO" );
			if(national_id_no==null) national_id_no="";

			nationality_code = rs.getString( "NATIONALITY_CODE" );
			if(nationality_code==null) nationality_code="";

			nationality_long_desc = rs.getString( "NATIONALITY_DESC" );
			if(nationality_long_desc  == null) nationality_long_desc  = "";

			// RESIDENCE ADDRESS & CONTACT DETAILS 
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

			// MAILING ADDRESS & CONTACT DETAILS 
			mail_addr_line1= rs.getString( "MAIL_ADDR_LINE1" );
			if(mail_addr_line1==null) mail_addr_line1="";

			mail_addr_line2= rs.getString( "MAIL_ADDR_LINE2" );
			if(mail_addr_line2==null) mail_addr_line2="";

			mail_addr_line3= rs.getString( "MAIL_ADDR_LINE3" );
			if(mail_addr_line3==null) mail_addr_line3="";

			mail_addr_line4= rs.getString( "MAIL_ADDR_LINE4" );
			if(mail_addr_line4==null) mail_addr_line4="";

			mail_town_code		= rs.getString("MAIL_TOWN_CODE");
			if(mail_town_code==null) mail_town_code="";

			mail_town_desc		= rs.getString("MAIL_TOWN_DESCRIPTION");
			if(mail_town_desc==null) mail_town_desc="";

			mail_area_code		= rs.getString("MAIL_AREA_CODE");
			if(mail_area_code==null) mail_area_code="";

			mail_area_desc		= rs.getString("MAIL_AREA_DESCRIPTION");
			if(mail_area_desc==null) mail_area_desc="";

			mail_region_code	= rs.getString("MAIL_REGION_CODE");
			if(mail_region_code==null) mail_region_code="";

			mail_region_desc	= rs.getString("MAIL_REGION_DESCRIPTION");
			if(mail_region_desc==null) mail_region_desc="";

			mail_postal_code	= rs.getString("MAIL_POSTAL_CODE");
			if(mail_postal_code==null) mail_postal_code="";

			mail_postal_code_desc	= rs.getString("mail_postal_code_desc");
			if(mail_postal_code_desc==null) mail_postal_code_desc="";

			mail_country_code	= rs.getString("MAIL_COUNTRY_CODE");
			if(mail_country_code==null) mail_country_code="";

			mail_country_desc	= rs.getString("MAIL_COUNTRY_DESCRIPTION");
			if(mail_country_desc==null) mail_country_desc="";

			// TEL NO & EMAIL-ID DETAILS 
			oth_contact_no       = rs.getString( "lodger_off_tel_num" );
			if(oth_contact_no ==null)		oth_contact_no ="";  

			other_tel_no       = rs.getString( "lodger_res_tel_num" );
			if(other_tel_no ==null)		other_tel_no ="";  

			email_id= rs.getString( "LODGER_EMAIL" );
			if(email_id==null) email_id="";

			String DOB= rs.getString( "DOB" );
			if(DOB==null) DOB="";

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
			lodger_name_loc_lang	= checkForNull(rs.getString("LODGER_NAME_LOC_LANG"));
	}
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
if(mode.equals("insert")){
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
	if(Category.equals("A"))
		{
		   out.println( "<td colspan='4' class='columnheader' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonDetails.label","ip_labels")+"</td>" ) ;
		}
		else
		{
		   out.println( "<td colspan='4' class='COLUMNHEADER' 	align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LodgerDetails.label","ip_labels")+"</td>" ) ;
		}	
            _bw.write(_wl_block17Bytes, _wl_block17);
	if(mode.equals("insert"))
	{	
            _bw.write(_wl_block18Bytes, _wl_block18);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("readonly_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[0]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block22Bytes, _wl_block22);
	}
	else
	{	
            _bw.write(_wl_block23Bytes, _wl_block23);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patientId
                        )},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("readonly_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[0]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[1]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
	}	
            _bw.write(_wl_block25Bytes, _wl_block25);

if(!mode.equals("insert")) 
{


            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(lodger_patient_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nameprefix));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(lodger_name_loc_lang));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(lodger_name_loc_lang));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(place_of_birth_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( place_of_birth_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( place_of_birth_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(nationality_long_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alt_id3_exp_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(alt_id4_exp_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ethnic_description));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(eth_grp));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(res_addr_line1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(res_addr_line2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(res_addr_line3));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(res_addr_line4));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(postal_code_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(mail_town_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(mail_town_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(mail_area_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(mail_area_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(mail_postal_code_desc));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(other_tel_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
 } 
            _bw.write(_wl_block2Bytes, _wl_block2);

if(mode.equals("insert")) 
{

            _bw.write(_wl_block111Bytes, _wl_block111);
 } 
            _bw.write(_wl_block2Bytes, _wl_block2);
  String label ="";

            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
 			
	out.println("<td width='20%' class='label' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforStay.label","ip_labels")+"</td><td width='30%' class='fields' nowrap>");
	 
	if(sql.length() > 0) sql.delete(0,sql.length());	
	sql.append(" select reason_for_stay_code, short_desc from IP_REASON_FOR_LOD_STAY_LANG_VW where language_id='"+locale+"' and eff_status = 'E'" );

	if (mode.equals("update"))
		sql.append(" and reason_for_stay_code='"+reason_for_stay+"' " );
	
	sql.append(" order by short_desc");
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql.toString()) ;

	if(rs!=null)
	{
		if(mode.equals ("insert"))
		{
			out.println( "<select name='reason_for_stay' id='reason_for_stay' >" ); 
			out.println("<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>") ;
		}

		while ( rs.next() )
		{
			if(mode.equals("insert"))
			{
				out.println( "<option value= \""+ rs.getString(1) +"\" >" + rs.getString(2) + "</option>" ) ;
			}
			else
			{
				out.println("<B> ");
				out.println(rs.getString(2)) ; 
				out.println("</B> ");
				//out.println(" <td width='25%'>&nbsp;</td>");
			}
		}
	}

	if(mode.equals("insert"))
		out.println( "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>");

	out.println("</td>");
	out.println("<td width='25%'class='label'>&nbsp;</td>");
	out.println("<td width='25%'class='label'>&nbsp;</td>");

	if(mode.equals("update"))
	{
	//	out.println(" <tr><td colspan='3'>&nbsp;</td><td >&nbsp;</td></tr>");
	}
	
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
	if(mode.equals("insert"))
	{	
		String sysdateTime_display = DateUtils.convertDate(sysdateTime,"DMYHM","en",localeName);
	
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sysdateTime_display));
            _bw.write(_wl_block118Bytes, _wl_block118);
	}
	else
	{    
		out.println("<td class='QUERYDATA'>");
		out.println( Period_dat_dis_tim_fr);
	}	
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
	if(mode.equals("insert"))
	{	
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(Period_date_time_to));
            _bw.write(_wl_block122Bytes, _wl_block122);
	}
	else
	{
		if(mode.equals("update"))
		{   
			out.println("<td class='QUERYDATA'>");
			out.println(Period_dat_dis_tim_to) ;
		}
	}

            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
if(mode.equals("insert"))
	{
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
	else
	{
        out.println("<td class='QUERYDATA'>");
		if(nursing_desc ==null || nursing_desc.equals("null"))
			nursing_desc ="";  
		out.println(nursing_desc) ;
	}

            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
if(mode.equals("insert"))
		{
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(authorized_by));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block133Bytes, _wl_block133);
}
		else
		{  
			out.println("<td class='QUERYDATA'>");
			out.println( authorized_by ) ;
		}
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
if(mode.equals("insert"))
		{
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block138Bytes, _wl_block138);
}
		else
		{
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block141Bytes, _wl_block141);
if(mode.equals("update"))	
  {
	String currDate_display = DateUtils.convertDate(currDate,"DMYHM","en",localeName);			

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(label));

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(check_in_date_time));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(sysdateTime));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(currDate_display));
            _bw.write(_wl_block146Bytes, _wl_block146);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
if(mode.equals("update"))
	{	
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block148Bytes, _wl_block148);
}
	else
	{	
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block151Bytes, _wl_block151);
	}
	
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(Category));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(lodger_ref_no));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(label));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(Lodger_Max_RefNo));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(Lodger_Next_RefNo));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block164Bytes, _wl_block164);

if(openWindow.equals("NO"))
{
	out.println("<script>parent.window.close();</script>");
}
}catch(Exception e) {out.println(e.toString());}

finally
{
	try
	{
		if (rs != null)			rs.close();
		if (stmt != null)		stmt.close();
		if (rs_opn != null)		rs_opn.close();
		if (stmt_opn != null)	stmt_opn.close();
		//if (PatIDRS != null)	PatIDRS.close();
		// if (PatIDStmt != null)	PatIDStmt.close();
	}
	catch(Exception e)
	{out.println("Exception in tryCatch : "+ e.toString());}
	ConnectionManager.returnConnection(con,request);
}     
            _bw.write(_wl_block165Bytes, _wl_block165);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.staydetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodto.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.checkoutdatetime.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
