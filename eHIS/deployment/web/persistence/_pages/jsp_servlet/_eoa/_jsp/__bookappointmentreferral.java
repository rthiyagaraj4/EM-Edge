package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __bookappointmentreferral extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BookAppointmentReferral.jsp", 1731498327200L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="   \n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\tvar err_age1 = getMessage( \"DECEASED_NOT_ALLOWED\",\"OA\" ) ;\t\n\t\t\t\t\talert(err_age1);\n\t\t\t\t\tclear_all_fun1(\"R\");\n\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\tvar err_age2 = getMessage( \"SUSPENDED_NOT_ALLOWED\" ,\"OA\") ;\n\t\t\t\t\talert(err_age2);\n\t\t\t\t\tclear_all_fun1(\"R\");\n\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\tvar err_age3 = getMessage( \"INACTIVE_PATIENT\",\"OA\" ) ;\n\t\t\t\t\talert(err_age3);\n\t\t\t\t\tclear_all_fun1(\"R\");\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\tvar err_age3 = getMessage( \"INVALID_PATIENT\" ,\"MP\") ;\n\t\t\t\t\talert(\"hi\"+err_age3);\n\t\t\t\t\tclear_all_fun1(\"R\");\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\tdocument.getElementById(\"SecResource\").disabled=false;\n\t\t\t\t\tdocument.getElementById(\"SecResCheck\").value=\'Y\';\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\tdocument.getElementById(\"SecResource\").disabled=true;\n\t\t\t\t\tdocument.getElementById(\"SecResCheck\").value=\'N\';\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\tdocument.forms[0].sec_req.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tdocument.forms[0].sec_sel.value=\"\";\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\tdocument.forms[0].order_catalog_criteria.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\tdocument.forms[0].ref_priority.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t//document.forms[0].patient_SecurityLevel.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\tdocument.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\t\t\t\n\t\t\t\tdocument.forms[0].patient_id.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\tdocument.forms[0].patient_id.disabled=false;\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\n\t\t\t\tdocument.getElementById(\"patient_name1\").innerHTML=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tdocument.getElementById(\"patient_name\").value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\n\t\t\t\tdocument.getElementById(\"patient_name_local_lang1\").innerHTML=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\tdocument.getElementById(\"patient_name_local_lang\").value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\t\t \n\t\t\t\tdocument.getElementById(\"patient_name_long\").value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\t\t\t \n\t\t\t\tdocument.getElementById(\"patient_name_loc_lang_long\").value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\tif\t(document.forms[0].national_id_no) \t\tdocument.forms[0].national_id_no.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t if\t(document.forms[0].national_id_no) \n\t\t\t\t\tdocument.forms[0].national_id_no.value=\'\';\t\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\n\t\t\tif\t(document.forms[0].national_id_no) \n\t\t\tdocument.forms[0].national_id_no.disabled=true;\n\t\t\n\t\t\tif (document.forms[0].alt_id1_no) {\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\tdocument.forms[0].alt_id1_no.value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\t\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\tdocument.forms[0].alt_id1_no.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\n\t\t\t\tdocument.forms[0].alt_id1_no.disabled=true;\n\t\t\t}\n\t\t\n\t\t\tif (document.forms[0].alt_id1_exp_date) {\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\tdocument.forms[0].alt_id1_exp_date.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\tdocument.forms[0].alt_id1_exp_date.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\n\t\t\t\tdocument.forms[0].alt_id1_exp_date.disabled=true;\n\t\t\t}\n\n\t\t\tif (document.forms[0].alt_id2_no) {\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\tdocument.forms[0].alt_id2_no.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\tdocument.forms[0].alt_id2_no.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\tdocument.forms[0].alt_id2_no.disabled=true;\n\t\t\t}\n\t\t\n\t\t\tif (document.forms[0].alt_id2_exp_date) {\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\tdocument.forms[0].alt_id2_exp_date.value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\tdocument.forms[0].alt_id2_exp_date.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\n\t\t\t\tdocument.forms[0].alt_id2_exp_date.disabled=true;\n\t\t\t}\n\n\t\t\n\t\t\tif (document.forms[0].alt_id3_no) {\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\tdocument.forms[0].alt_id3_no.value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\tdocument.forms[0].alt_id3_no.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t\t\t\tdocument.forms[0].alt_id3_no.disabled=true;\n\t\t\t}\n\t\t\n\t\t\tif (document.forms[0].alt_id3_exp_date) {\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\tdocument.forms[0].alt_id3_exp_date.value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\tdocument.forms[0].alt_id3_exp_date.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n\t\t\t\tdocument.forms[0].alt_id3_exp_date.disabled=true;\n\t\t\t}\n\t\t\n\t\t\tif (document.forms[0].alt_id4_no) {\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\tdocument.forms[0].alt_id4_no.value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\tdocument.forms[0].alt_id4_no.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\n\t\t\t\tdocument.forms[0].alt_id4_no.disabled=true;\n\t\t\t}\n\t\t\n\t\t\tif (document.forms[0].alt_id4_exp_date) {\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\tdocument.forms[0].alt_id4_exp_date.value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\tdocument.forms[0].alt_id4_exp_date.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n\t\t\t\tdocument.forms[0].alt_id4_exp_date.disabled=true;\n\t\t\t}\n\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\tdocument.forms[0].name_prefix.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\tdocument.forms[0].name_prefix.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\tdocument.forms[0].name_prefix.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t  if(document.forms[0].first_name) {\n\t\t\t\t document.forms[0].first_name.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t document.forms[0].first_name.disabled=true;\n\t\t\t\t if(document.forms[0].bf)\n\t\t\t\t document.forms[0].bf.disabled=true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t if(document.forms[0].second_name) {\n\t\t\t\t\tdocument.forms[0].second_name.value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\t\t\t\tdocument.forms[0].second_name.disabled=true;\n\t\t\t\t\tif(document.forms[0].bs)\n\t\t\t\t\tdocument.forms[0].bs.disabled=true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\tif(document.forms[0].third_name) {\n\t\t\t\t\tdocument.forms[0].third_name.value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"; \t\t\t\t\n\t\t\t\t\tdocument.forms[0].third_name.disabled=true;\n\t\t\t\t\tif(document.forms[0].bt)\n\t\t\t\t\tdocument.forms[0].bt.disabled=true;//added by  munisekhar  for [IN:046231]\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n    ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\tif(document.forms[0].family_name) {\n\t\t\t\tdocument.forms[0].family_name.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\t\t    document.forms[0].family_name.disabled=true;\n\t\t\t\tif(document.forms[0].bfam)\n\t\t\t\tdocument.forms[0].bfam.disabled=true;\n\t\t\t}\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\tdocument.forms[0].name_suffix.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\tdocument.forms[0].name_suffix.disabled=true;\n\t\t\t\tdocument.forms[0].name_suffix.disabled=true;\n\t\t\t\tdocument.forms[0].name_suffix.value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\tdocument.forms[0].name_suffix.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\tdocument.forms[0].name_suffix.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\tif(document.forms[0].name_prefix_oth_lang){\n\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\tif(document.forms[0].name_prefix_oth_lang){\n\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.value=\'\';\n\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\n\t\t\t\n\n\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\tif(document.forms[0].first_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].first_name_oth_lang.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\t\t\tdocument.forms[0].first_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bfo)\n\t\t\t\t\tdocument.forms[0].bfo.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\tif(document.forms[0].first_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].first_name_oth_lang.value=\'\';\n\t\t\t\t\tdocument.forms[0].first_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bfo)\n\t\t\t\t\tdocument.forms[0].bfo.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\tif(document.forms[0].second_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].second_name_oth_lang.value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\t\t\t\tdocument.forms[0].second_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bso)\n\t\t\t\t\tdocument.forms[0].bso.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\tif(document.forms[0].second_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].second_name_oth_lang.value=\'\';\n\t\t\t\t\tdocument.forms[0].second_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bso)\n\t\t\t\t\tdocument.forms[0].bso.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\tif(document.forms[0].third_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].third_name_oth_lang.value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\tdocument.forms[0].third_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bto)\n\t\t\t\t\tdocument.forms[0].bto.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\tif(document.forms[0].third_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].third_name_oth_lang.value=\'\';\n\t\t\t\t\tdocument.forms[0].third_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bto)\n\t\t\t\t\tdocument.forms[0].bto.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\tif(document.forms[0].family_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].family_name_oth_lang.value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\t\t\t\tdocument.forms[0].family_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bfamo)\n\t\t\t\t\tdocument.forms[0].bfamo.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\tif(document.forms[0].family_name_oth_lang){\n\t\t\t\t\tdocument.forms[0].family_name_oth_lang.value=\'\';\n\t\t\t\t\tdocument.forms[0].family_name_oth_lang.disabled=true;\n\t\t\t\t\tif(document.forms[0].bfamo)\n\t\t\t\t\tdocument.forms[0].bfamo.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\tif(document.forms[0].name_suffix_oth_lang){\n\t\t\t\tdocument.forms[0].name_suffix_oth_lang.value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\tdocument.forms[0].name_suffix_oth_lang.disabled=true;\n\t\t\t\t//document.forms[0].name_suffix_oth_lang.disabled=true;\n\t\t\t\t//document.forms[0].name_suffix_oth_lang.value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\tif(document.forms[0].name_suffix_oth_lang){\n\t\t\t\tdocument.forms[0].name_suffix_oth_lang.value=\'\';\n\t\t\t\tdocument.forms[0].name_suffix_oth_lang.disabled=true;\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\n\t\t\t\n\n\n\t\tdocument.forms[0].sex.value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\tdocument.forms[0].sex.disabled=true;\n\t\tdocument.forms[0].gen.value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\tdocument.forms[0].sex.disabled=true;\n\t\n\t\tdocument.forms[0].addr_line1.value = \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\tdocument.forms[0].addr_line2.value = \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\tdocument.forms[0].addr_line3.value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\tdocument.forms[0].addr_line4.value = \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\tdocument.forms[0].res_town_code.value = \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\tdocument.forms[0].res_town_desc.value = \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\n\t\tdocument.forms[0].res_area_code.value = \"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\t\tdocument.forms[0].res_area_desc.value = \"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\tdocument.forms[0].postal_code.value = \"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\";\n\t\tdocument.forms[0].region_code.value = \"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\";\n\n\t\tdocument.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"\n\t\tdocument.forms[0].m_postal_code_desc.value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\n\n\t\tdocument.forms[0].region_desc.value = \"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\tdocument.forms[0].country_code.value = \"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\";\n\t\tdocument.forms[0].country_desc.value = \"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\tdocument.forms[0].mail_addr_line1.value = \"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\tdocument.forms[0].mail_addr_line2.value = \"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\tdocument.forms[0].mail_addr_line3.value = \"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\t\tdocument.forms[0].mail_addr_line4.value = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\t\tdocument.forms[0].mail_res_town_code.value = \"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\t\tdocument.forms[0].mail_res_town_desc.value = \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n\t\tdocument.forms[0].mail_res_area_code.value = \"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\";\n\t\tdocument.forms[0].mail_res_area_desc.value =\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\";\n\t\tdocument.forms[0].mail_postal_code.value = \"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\";\n\t\tdocument.forms[0].mail_region_code.value = \"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\";\n\t\tdocument.forms[0].mail_region_desc.value = \"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\";\n\t\tdocument.forms[0].mail_country_code.value = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\";\n\t\tdocument.forms[0].mail_country_desc.value = \"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\t\tdocument.forms[0].contact1_no.value =\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\";\n\t\tdocument.forms[0].contact2_no.value =\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\";\n\t\tdocument.forms[0].email.value =\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\";\n\n\t\tdocument.forms[0].Birth_place_code.value =\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\";\n\t\tdocument.forms[0].birth_place.value =\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\";\n\t\t\n\t\tdocument.forms[0].place_of_birth.value =\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\";\n\t\tdocument.forms[0].place_of_birth.disabled = true;\n\t\tdocument.forms[0].nationality_code1.value = \"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\";\n\t\tdocument.forms[0].nationality_desc.value = \"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\";\n\t\tdocument.forms[0].nationality_desc.disabled = true;\n\t\tdocument.forms[0].nationality_id.disabled = true;\n\t\tdocument.forms[0].birth_place.disabled = true;\n\t\tdocument.forms[0].b_birth.disabled = true;\n\n\t\tdocument.forms[0].alt_addr_line1.value = \"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"\n\t\tdocument.forms[0].alt_addr_line2.value =\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"\n\t\tdocument.forms[0].alt_addr_line3.value = \"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"\n\t\tdocument.forms[0].alt_addr_line4.value = \"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"\n\t\tdocument.forms[0].alt_area_code.value = \"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"\n\t\tdocument.forms[0].alt_area_desc.value = \"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"\n\t\tdocument.forms[0].alt_town_code.value = \"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"\n\t\tdocument.forms[0].alt_town_desc.value = \"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"\n\t\tdocument.forms[0].alt_region_code.value = \"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"\n\t\tdocument.forms[0].alt_region_desc.value = \"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"\n\t\tdocument.forms[0].alt_postal_code.value = \"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"\n\t\tdocument.forms[0].alt_postal_desc.value = \"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"\n\t\tdocument.forms[0].alt_country_code.value = \"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"\n\t\tdocument.forms[0].alt_country_desc.value = \"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"\n\n\t\tif(\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'==\'Y\'){\n\t\t\tdocument.forms[0].citizen_yn[0].checked = true;\n\n\t\t}else{\n\t\t\tdocument.forms[0].citizen_yn[1].checked = true;\n\t\t\t//document.getElementById(\"eth_gif\").style.visibility=\'hidden\';\n\t\t\t//document.getElementById(\"race_yn\").value = \'N\';\n\t\t}\n\n\t\tif(\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'==\'Y\'){\n\t\t\tdocument.forms[0].legal_yn[0].checked = true\n\n\t\t}else{\n\t\t\tdocument.forms[0].legal_yn[1].checked = true\n\n\t\t}\n\n\t\tdocument.forms[0].citizen_yn[0].disabled = true\n\t\tdocument.forms[0].citizen_yn[1].disabled = true\n\t\tdocument.forms[0].legal_yn[0].disabled = true\n\t\tdocument.forms[0].legal_yn[1].disabled = true\n\t\tdocument.forms[0].search.disabled = true\n\t\tdocument.forms[0].dob.disabled = true\n\n\t\n\t\tif(document.forms[0].other_alt_type){\n\n\t\t\tdocument.forms[0].other_alt_type.value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\";\n\t\t\tdocument.forms[0].other_alt_type.disabled=true;\n\n\t\t}\n\t\tif(document.forms[0].other_alt_Id){\n\n\t\t\tdocument.forms[0].other_alt_Id.value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\";\n\t\t\tdocument.forms[0].other_alt_Id.disabled=true;\n\t\t}\n\n\t\tif(document.getElementById(\"alt_id_exp_dt1\"))\n\t\t\tdocument.getElementById(\"alt_id_exp_dt1\").disabled=true;\n\n\n\t\tif(document.getElementById(\"alt_id_exp_dt2\"))\n\t\t\tdocument.getElementById(\"alt_id_exp_dt2\").disabled=true;\n\n\t\t\n\n\t\tif(document.forms[0].ethnic_group ){\t\n\n\t\t\tif(\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' !=\'\'){\n\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\";\n\t\t\t\topt.value=  \"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\";\n\t\t\t\t\t\n\t\t\t\tdocument.forms[0].ethnic_group.add(opt);\n\t\t\t\t//document.forms[0].ethnic_group.value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\";\n\t\t\t}else{\n\t\t\t\t\n\t\t\t\tdocument.forms[0].ethnic_group.value=\'\';\n\t\t\t}\n\n\t\t\tdocument.forms[0].ethnic_group.disabled = true\n\t\t}\n\n\t\tif(document.forms[0].race_desc){\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' !=\'\'){\t\t\t\t\n\t\t\t\tdocument.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\";\n\t\t\t\tdocument.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\";\n\t\t\t\tdocument.forms[0].race_desc.disabled = true;\n\t\t\t\tdocument.forms[0].race_desc_id.disabled = true;\n\t\t\t}else{\t\t\t\t\n\t\t\t\tdocument.forms[0].race_code.value=\'\';\n\t\t\t\tdocument.forms[0].race_desc.value=\'\';\n\t\t\t}\t\t\t\n\t\t} \n\n\t\tdocument.forms[0].date_of_birth.value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\";\n\t\tdocument.forms[0].date_of_birth.disabled=true;\n\t\t\n\t\tdocument.forms[0].b_age.value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\";\n\t\tdocument.forms[0].b_age.disabled=true;\n\t\tdocument.forms[0].b_months.value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\";\n\t\tdocument.forms[0].b_months.disabled=true;\n\t\tdocument.forms[0].b_days.value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\";\n\t\tdocument.forms[0].b_days.disabled=true;\n\t\tif(document.forms[0].pat_cat_code){\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' !=\'\'){\t\t\t\t\n\t\t\t\tdocument.forms[0].pat_cat_code.value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\";\n\t\t\t\tdocument.forms[0].pat_cat_desc.value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\";\n\t\t\t\tdocument.forms[0].pat_cat_desc.disabled = true;\n\t\t\t\tdocument.forms[0].pat_cat_code_id.disabled = true;\n\t\t\t}else{\t\t\t\t\n\t\t\t\tdocument.forms[0].pat_cat_code.value=\'\';\n\t\t\t\tdocument.forms[0].pat_cat_desc.value=\'\';\n\t\t\t}\t\t\t\n\t\t}\n\t\t\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\t\t\t\t\n\t\t\tdocument.forms[0].reason.value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\";\t\t\t\t\t\t\t\n\t\t\tdocument.forms[0].reason_for_contact.value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\";\t\t\t\t\t\t\t\n\t\t\tdocument.forms[0].rec_date.value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\";\n\t\t\tdocument.forms[0].remarks.value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\";\n\t\t\tdocument.forms[0].mode.value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="  \n\t\talert(\"hi 1033\");\n\t\t\talert(getMessage(\'INVALID_REF_ID\',\'OP\'));\n\t\t\tdocument.forms[0].source.value=\'\';\n\t\t\t//document.forms[0].search.disabled = false;\n\n\t\t\tclearAll1()\n\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="  \n\talert(\"hi 1044\");\n\t\talert(getMessage(\'INVALID_REF_ID\',\'OP\'));\n\t\tdocument.forms[0].source.value=\'\';\n\t\t//document.forms[0].search.disabled = false; \n\t\tclearAll1()\n\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\talert(\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\');\t\n\tclear_fun_all();\n\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );


public static String checkForNull(String inputString)
{
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Map hash = new HashMap();
hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Connection conn			=ConnectionManager.getConnection(request);
String facilityid		=(String)session.getValue("facility_id");
request.setCharacterEncoding("UTF-8");	

String ref_id=(String)hash.get("ref_id");
if(ref_id==null || ref_id.equals("null"))
ref_id="";
String p_speciality_code=(String)hash.get("p_speciality_code");
String pract_id=(String)hash.get("pract_id");
String calledFor=(String)hash.get("calledFor");

String apptrefno=(String)hash.get("apptrefno");
if(apptrefno ==null) apptrefno="";
String from_page=(String)hash.get("from_page");
if(from_page==null) from_page="";
String wait_list_num=(String)hash.get("wait_list_num");
if(wait_list_num==null || wait_list_num.equals("null"))
wait_list_num="";
String req_id=(String)hash.get("req_id");
if(req_id ==null) req_id="";
String alcn_criteria_pop=(String)hash.get("alcn_criteria_pop");
if(alcn_criteria_pop!=null) alcn_criteria_pop="";
String locale=(String)session.getAttribute("LOCALE");
String receiving_date_time_display="";
String reason_for_transfer="";
String receiving_date_time="";
String appt_remarks="";
String mode_of_contact="";
String contact_reason_code = "";


String to_pract_id		="",alt_id1_exp_date	="",alt_id2_exp_date	="",alt_id3_exp_date	="",alt_id4_exp_date	="",appt_num="",remarks="",contact_rea="",visit_type_desc="",recieve_date_time="",visit_ind="",ref_id_value="",cont_res_code="";

String alt_id1_exp_date_display="";
String alt_id2_exp_date_display="";
String alt_id3_exp_date_display="";
String alt_id4_exp_date_display="";
String dateofbirth_greg="";

int no_slots_val=0;

String c_name_prefix_accept_yn="",c_first_name_accept_yn="",c_second_name_accept_yn="",c_third_name_accept_yn="",c_family_name_accept_yn="",c_name_suffix_accept_yn="",ref_priority="";

String	BIRTH_PLACE_DESC="",CITIZEN_YN="",LEGAL_ILLEGAL_YN="",RACE_CODE="",RACE_DESC="",ETHNIC_GRP_CODE="",ETHNIC_GROUP_DESC="",BIRTH_PLACE_CODE="",birth_place_description="",NATIONALITY_CODE="",NATIONALITY="",ADDR_LINE1="",ADDR_LINE2="",ADDR_LINE3="",ADDR_LINE4="",REGION_CODE="",REGION_DESC="",RES_AREA_CODE="",RES_AREA_DESC="",RES_TOWN_CODE="",RES_TOWN_DESC="";

String	POSTAL_CODE="",COUNTRY_CODE="",COUNTRY_NAME="",CONTACT1_NO="",CONTACT2_NO="",EMAIL_ID="",MAIL_ADDR_LINE1="",MAIL_ADDR_LINE2="",MAIL_ADDR_LINE3="",MAIL_ADDR_LINE4="",MAIL_REGION_CODE="",MAIL_REGION_DESC="",MAIL_RES_AREA_CODE="",MAIL_AREA_DESC="",MAIL_RES_TOWN_CODE="",MAIL_RES_TOWN_DESC="",MAIL_POSTAL_CODE="",MAIL_COUNTRY_CODE="",MAIL_COUNTRY_NAME ="",OTH_ALT_ID_NO="",OTH_ALT_TYPE="",appt_clinic_code="",POSTAL_CODE_DESC="",MAIL_POSTAL_CODE_DESC="";

String alt_addr_line1="", alt_addr_line2="", alt_addr_line3="", alt_addr_line4="", alt_town_code="", alt_area_code="", alt_region_code="", alt_postal_code="", alt_country_code="", alt_area_desc="", alt_town_desc="", alt_region_desc="", alt_postal_desc="", alt_country_desc="";//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601

boolean count_referral	=false;
String prm_res_class = (String)hash.get("prm_res_class");
if(prm_res_class ==null) prm_res_class="";

Statement stmt			=conn.createStatement();
Statement stmtap		=conn.createStatement();
Statement c_stmtn=conn.createStatement();
Statement stmt3=null,stmtpat=null,stmtc_p=null,stmt_wait_sec=null,stmt12=null;


ResultSet rsc_p=null,rset=null,rs=null,rs3=null,rsap=null,c_rs=null,rspat=null,rs12=null,rsappt=null,rs_wait_sec=null,rsappt_visit=null,rset_wtlt=null;
String pat_cat_code="",order_wtlt_code="",nationality_code="";

java.lang.StringBuffer sqlm=new java.lang.StringBuffer();
count_referral=true;
boolean valid_patient=true;
			String patient_cat_code="";
			String patient_cat_desc="";
try{	

	if(count_referral){
		if(to_pract_id!=null && to_pract_id.equals(pract_id)){
			count_referral=true;			
		}
		if(count_referral){				

			c_rs=c_stmtn.executeQuery("select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param");
			c_rs.next();
			c_name_prefix_accept_yn=c_rs.getString("name_prefix_accept_yn");
			c_first_name_accept_yn=c_rs.getString("first_name_accept_yn");
			c_second_name_accept_yn=c_rs.getString("second_name_accept_yn");
			c_third_name_accept_yn=c_rs.getString("third_name_accept_yn");
			c_family_name_accept_yn=c_rs.getString("family_name_accept_yn");
			c_name_suffix_accept_yn=c_rs.getString("name_suffix_accept_yn");
			if(c_rs !=null) c_rs.close();
			if(calledFor.equals("Referal")){
				sqlm.append("SELECT PATIENT_ID, PATIENT_NAME, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, NAME_SUFFIX, SEX, DATE_OF_BIRTH, BIRTH_PLACE_CODE, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,  CITIZEN_YN, LEGAL_ILLEGAL_YN, RACE_CODE, MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC, ETHNIC_GRP_CODE, MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC, NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(NATIONALITY_CODE,'"+locale+"','3') NATIONALITY, ADDR_LINE1 ADDRESS, ADDR_LINE2, ADDR_LINE3, ADDR_LINE4, REGION_CODE, MP_GET_DESC.MP_REGION(REGION_CODE,'"+locale+"','1') REGION_DESC, RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC, COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') COUNTRY_NAME, CONTACT1_NO, CONTACT2_NO, EMAIL_ID, MAIL_ADDR_LINE1, MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1')MAIL_REGION_DESC, MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_RES_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, MAIL_RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+locale+"','1') MAIL_RES_TOWN_DESC, MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC, MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc, REFERRAL_PRIORITY, ALT_ID1_NO, ALT_ID2_NO, ALT_ID3_NO, ALT_ID3_NO, ALT_ID4_NO, NATIONAL_ID_NO,	TO_CHAR(ALT_ID1_DATE,'DD/MM/YYYY') ALT_ID1_EXP_DATE, TO_CHAR(ALT_ID2_DATE,'DD/MM/YYYY') ALT_ID2_EXP_DATE, TO_CHAR(ALT_ID3_DATE,'DD/MM/YYYY') ALT_ID3_EXP_DATE, TO_CHAR(ALT_ID4_DATE,'DD/MM/YYYY') ALT_ID4_EXP_DATE, OTH_ALT_ID_NO, OTH_ALT_ID_TYPE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID='"+facilityid+"' AND  REFERRAL_ID='"+ref_id+"' ");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
				
				sqlm.append("AND STATUS IN('O','D') AND TO_SPECIALITY_CODE ='"+p_speciality_code+"'");
				

			}else if(calledFor.equals("WaitList") && !wait_list_num.equals("") ){
				sqlm.append("SELECT PATIENT_ID, PATIENT_NAME, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, NAME_SUFFIX, GENDER SEX, DATE_OF_BIRTH, BIRTH_PLACE_CODE, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,  CITIZEN_YN, LEGAL_YN,  RACE_CODE, MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC, ETHNIC_GROUP_CODE ETHNIC_GRP_CODE, MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC, RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME, NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(nationality_code,'"+locale+"','3') NATIONALITY, RES_ADDR_LINE1 ADDRESS, RES_ADDR_LINE2 ADDR_LINE2, RES_ADDR_LINE3 ADDR_LINE3, RES_ADDR_LINE4 ADDR_LINE4, RES_REGION_CODE REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') REGION_DESC, RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, RES_POSTAL_CODE POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(RES_POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC, MAIL_COUNTRY_CODE , MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME, RES_TEL_NO CONTACT1_NO, OTH_CONTACT_NO CONTACT2_NO, EMAIL_ID, MAIL_ADDR_LINE1, MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1')MAIL_REGION_DESC, MAIL_AREA_CODE MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, MAIL_TOWN_CODE MAIL_RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_RES_TOWN_DESC, MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,'1' REFERRAL_PRIORITY, ALT_ID1_NO, ALT_ID2_NO, ALT_ID3_NO, ALT_ID3_NO, ALT_ID4_NO, NATIONAL_ID_NO,	TO_CHAR(ALT_ID1_EXP_DATE,'DD/MM/YYYY') ALT_ID1_EXP_DATE, TO_CHAR(ALT_ID2_EXP_DATE,'DD/MM/YYYY') ALT_ID2_EXP_DATE, TO_CHAR(ALT_ID3_EXP_DATE,'DD/MM/YYYY') ALT_ID3_EXP_DATE, TO_CHAR(ALT_ID4_EXP_DATE,'DD/MM/YYYY') ALT_ID4_EXP_DATE, OTH_ALT_ID_NO, OTH_ALT_ID_TYPE, BOOKING_REF_NO ,ORDER_CATALOG_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc FROM PR_WAIT_LIST WHERE FACILITY_ID='"+facilityid+"' AND  WAIT_LIST_NO='"+wait_list_num+"'");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601

				
			}else if(calledFor.equals("modify_appt"))
			{
				sqlm.append("select PATIENT_ID,ORDER_CATALOG_CODE, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,GENDER SEX,RACE_CODE,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,ETHNIC_GROUP_CODE,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_DESC,BIRTH_PLACE_CODE,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_YN,RES_ADDR_LINE1 ADDRESS ,RES_ADDR_LINE2 ADDR_LINE2,RES_ADDR_LINE3 ADDR_LINE3,RES_ADDR_LINE4 ADDR_LINE4,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,RES_AREA_CODE,POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_CODE_DESC,COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') NATIONALITY_DESC,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC,RES_REGION_CODE REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') REGION_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE MAIL_RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_RES_TOWN_DESC,MAIL_AREA_CODE MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1')  MAIL_AREA_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+locale+"','2') MAIL_POSTAL_CODE_DESC,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1')MAIL_COUNTRY_NAME,referral_priority,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,date_of_birth,RES_TEL_NO CONTACT1_NO,OTH_CONTACT_NO CONTACT2_NO ,EMAIL_ID ,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,patient_long_name,patient_long_name_loc_lang ,RES_COUNTRY_CODE , MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,to_char(RECEIVING_DATE_TIME,'dd/mm/yyyy hh24:mi') RECEIVING_DATE_TIME,APPT_REMARKS,MODE_OF_CONTACT,contact_reason_code, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc from oa_appt where appt_ref_no='"+apptrefno+"' and FACILITY_ID='"+facilityid+"'");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
			}
			/*else if(calledFor.equals("Mr_appt"))
			{
				sqlm="select PATIENT_ID, PATIENT_NAME,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NATIONAL_ID_NO,ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,SEX,GENDER,RACE_CODE,RACE_DESC,ETHNIC_GRP_CODE,ETHNIC_DESC,BIRTH_PLACE_CODE,BIRTH_PLACE_DESC,CITIZEN_YN,LEGAL_ILLEGAL_YN,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,RES_TOWN_SHORT_DESC,RES_AREA_CODE,RES_AREA_SHORT_DESC,RES_REGION_CODE,RES_REGION_SHORT_DESC,RES_POSTAL_CODE,RES_POSTAL_SHORT_DESC,RES_COUNTRY_CODE,RES_COUNTRY_LONG_DESC,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MAIL_TOWN_SHORT_DESC,MAIL_AREA_CODE,MAIL_AREA_SHORT_DESC,MAIL_REGION_CODE,MAIL_REGION_SHORT_DESC,MAIL_POSTAL_CODE,MAIL_POSTAL_SHORT_DESC,MAIL_COUNTRY_CODE,MAIL_COUNTRY_LONG_DESC,APPL_RES_TEL_NO,APPL_MOB_TEL_NO,APPL_EMAIL_ID,alt_id1_no,alt_id2_no,alt_id3_no,alt_id3_no,alt_id4_no,national_id_no,		to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy')alt_id1_exp_date,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') alt_id2_exp_date,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') alt_id3_exp_date,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') alt_id4_exp_date,NATIONALITY_CODE,date_of_birth from MR_REPORT_REQUEST_HDR_VW where request_id='"+req_id+"' and FACILITY_ID='"+facilityid+"' ";
			}*/

			if(!sqlm.toString().equals("")){
			rset=stmt.executeQuery(sqlm.toString());

			if(rset!=null) {
			if(rset.next()){
			String patientid=rset.getString("patient_id");
			if (patientid==null) patientid="";
			if(!patientid.equals("")) {
				String chkst=patdata.CheckStatus(conn,patientid);
				if(chkst.equals("DECEASED")) {
					valid_patient=false;
					
            _bw.write(_wl_block3Bytes, _wl_block3);

				}else if(chkst.equals("SUSPENDED")) {
					valid_patient=false;
					
            _bw.write(_wl_block4Bytes, _wl_block4);

			    }else if(chkst.equals("INACTIVE")) {
					valid_patient=false;
					
            _bw.write(_wl_block5Bytes, _wl_block5);

			   }else if(chkst.equals("INVALID_PATIENT")) {
					valid_patient=false;
					
            _bw.write(_wl_block6Bytes, _wl_block6);
 }
		}	
		
		if((patientid.equals("")&&(valid_patient))||((!patientid.equals(""))&&(valid_patient))) {
				String patientname=rset.getString("patient_name");
				String patientname_local_lang =rset.getString("PATIENT_NAME_LOC_LANG");
				String patient_long_name =rset.getString("patient_long_name")==null?"":rset.getString("patient_long_name");
				String patient_long_name_loc_lang =rset.getString("patient_long_name_loc_lang")==null?"":rset.getString("patient_long_name_loc_lang");
				if(patientname_local_lang ==null) patientname_local_lang="";
				if(!calledFor.equals("modify_appt")){
					nationality_code=rset.getString("nationality_code");
				}else
				{
					nationality_code=rset.getString("country_code");
				}
			 if(nationality_code==null)	 nationality_code="";
				

			String nationalid=null;
			String alternateid=null;
			String alternateid1=null;
			String alternateid3=null;
			String alternateid4=null;
			String prefix=rset.getString("name_prefix");
			String firstname=rset.getString("first_name");
			ref_priority	=rset.getString("referral_priority");
			if(firstname==null)	 
				firstname="";
			String secondname=rset.getString("second_name");
			if(secondname==null)
				secondname="";

			String thirdname=rset.getString("third_name");
			if(thirdname==null)
				thirdname="";
			String familyname=rset.getString("family_name");
			 if(familyname==null) familyname="";
			BIRTH_PLACE_DESC=rset.getString("BIRTH_PLACE_DESC");
			 if(BIRTH_PLACE_DESC==null) BIRTH_PLACE_DESC="";
			CITIZEN_YN=rset.getString("CITIZEN_YN");
			 if(CITIZEN_YN==null) CITIZEN_YN="";

			if(calledFor.equals("Referal")){
						LEGAL_ILLEGAL_YN=rset.getString("LEGAL_ILLEGAL_YN");
			}else
			{
				LEGAL_ILLEGAL_YN=rset.getString("LEGAL_YN");
			}
			 if(LEGAL_ILLEGAL_YN==null) LEGAL_ILLEGAL_YN="";


			RACE_CODE=rset.getString("RACE_CODE");
			 if(RACE_CODE==null) RACE_CODE="";
			RACE_DESC=rset.getString("RACE_DESC");
			 if(RACE_DESC==null) RACE_DESC="";
			
		if(!calledFor.equals("modify_appt")){

			ETHNIC_GRP_CODE=rset.getString("ETHNIC_GRP_CODE");
			 if(ETHNIC_GRP_CODE==null) ETHNIC_GRP_CODE="";
			ETHNIC_GROUP_DESC=rset.getString("ETHNIC_GROUP_DESC");
			 if(ETHNIC_GROUP_DESC==null) ETHNIC_GROUP_DESC="";
		}else
		{
			
			ETHNIC_GRP_CODE=rset.getString("ETHNIC_GROUP_CODE");
			 if(ETHNIC_GRP_CODE==null) ETHNIC_GRP_CODE="";
			//ETHNIC_GROUP_DESC=rset.getString("ETHNIC_GROUP_DESC");
			// if(ETHNIC_GROUP_DESC==null) ETHNIC_GROUP_DESC="";
		}

			BIRTH_PLACE_CODE=rset.getString("BIRTH_PLACE_CODE");
			 if(BIRTH_PLACE_CODE==null) BIRTH_PLACE_CODE="";
			birth_place_description=rset.getString("BIRTH_PLACE_DESC");
			 if(birth_place_description==null) birth_place_description="";

if(!calledFor.equals("modify_appt")){
			NATIONALITY_CODE=rset.getString("NATIONALITY_CODE");
			 if(NATIONALITY_CODE==null) NATIONALITY_CODE="";
			NATIONALITY=rset.getString("NATIONALITY");
			if(NATIONALITY==null) NATIONALITY="";
}else
{
	NATIONALITY_CODE=rset.getString("COUNTRY_CODE");
			 if(NATIONALITY_CODE==null) NATIONALITY_CODE="";
			NATIONALITY=rset.getString("NATIONALITY_DESC");
			if(NATIONALITY==null) NATIONALITY="";
}
		 
			ADDR_LINE1=rset.getString("address");
			 if(ADDR_LINE1==null) ADDR_LINE1="";
			ADDR_LINE2=rset.getString("ADDR_LINE2");
			 if(ADDR_LINE2==null) ADDR_LINE2="";
			ADDR_LINE3=rset.getString("ADDR_LINE3");
			 if(ADDR_LINE3==null) ADDR_LINE3="";
			ADDR_LINE4=rset.getString("ADDR_LINE4");
			 if(ADDR_LINE4==null) ADDR_LINE4="";
			
			REGION_CODE=rset.getString("REGION_CODE");
			 if(REGION_CODE==null) REGION_CODE="";
			REGION_DESC=rset.getString("REGION_DESC");
			 if(REGION_DESC==null) REGION_DESC="";
			
			RES_AREA_CODE=rset.getString("RES_AREA_CODE");
			 if(RES_AREA_CODE==null) RES_AREA_CODE="";
			RES_AREA_DESC=rset.getString("RES_AREA_DESC");
			 if(RES_AREA_DESC==null) RES_AREA_DESC="";
			
			RES_TOWN_CODE=rset.getString("RES_TOWN_CODE");
			 if(RES_TOWN_CODE==null) RES_TOWN_CODE="";
			RES_TOWN_DESC=rset.getString("RES_TOWN_DESC");
			 if(RES_TOWN_DESC==null) RES_TOWN_DESC="";
			POSTAL_CODE=rset.getString("POSTAL_CODE");
			 if(POSTAL_CODE==null) POSTAL_CODE="";

			 POSTAL_CODE_DESC=rset.getString("POSTAL_CODE_DESC");
			 if(POSTAL_CODE_DESC==null) POSTAL_CODE_DESC="";
			
			if(calledFor.equals("WaitList") ||calledFor.equals("modify_appt")){
			COUNTRY_CODE=rset.getString("RES_COUNTRY_CODE");	
			order_wtlt_code= rset.getString("ORDER_CATALOG_CODE");
			if(order_wtlt_code ==null) order_wtlt_code="";
			}else
			{
			COUNTRY_CODE=rset.getString("COUNTRY_CODE");
			}
			 if(COUNTRY_CODE==null) COUNTRY_CODE="";
			if(calledFor.equals("WaitList") || calledFor.equals("modify_appt") ){
			COUNTRY_NAME=rset.getString("RES_COUNTRY_NAME");
			}else
			{
				COUNTRY_NAME=rset.getString("COUNTRY_NAME");
			}

			 if(COUNTRY_NAME==null) COUNTRY_NAME="";
			CONTACT1_NO=rset.getString("CONTACT1_NO");
			 if(CONTACT1_NO==null) CONTACT1_NO="";
			CONTACT2_NO=rset.getString("CONTACT2_NO");
			 if(CONTACT2_NO==null) CONTACT2_NO="";
			EMAIL_ID=rset.getString("EMAIL_ID");
			 if(EMAIL_ID==null) EMAIL_ID="";

			MAIL_ADDR_LINE1=rset.getString("MAIL_ADDR_LINE1");
			 if(MAIL_ADDR_LINE1==null) MAIL_ADDR_LINE1="";
			MAIL_ADDR_LINE2=rset.getString("MAIL_ADDR_LINE2");
			 if(MAIL_ADDR_LINE2==null) MAIL_ADDR_LINE2="";
			MAIL_ADDR_LINE3=rset.getString("MAIL_ADDR_LINE3");
			 if(MAIL_ADDR_LINE3==null) MAIL_ADDR_LINE3="";
			MAIL_ADDR_LINE4=rset.getString("MAIL_ADDR_LINE4");
			 if(MAIL_ADDR_LINE4==null) MAIL_ADDR_LINE4="";
			MAIL_REGION_CODE=rset.getString("MAIL_REGION_CODE");
			 if(MAIL_REGION_CODE==null) MAIL_REGION_CODE="";
			MAIL_REGION_DESC=rset.getString("MAIL_REGION_DESC");
			 if(MAIL_REGION_DESC==null) MAIL_REGION_DESC="";
			MAIL_RES_AREA_CODE=rset.getString("MAIL_RES_AREA_CODE");
			 if(MAIL_RES_AREA_CODE==null) MAIL_RES_AREA_CODE="";
			MAIL_AREA_DESC=rset.getString("MAIL_AREA_DESC");
			 if(MAIL_AREA_DESC==null) MAIL_AREA_DESC="";
			MAIL_RES_TOWN_CODE=rset.getString("MAIL_RES_TOWN_CODE");
			 if(MAIL_RES_TOWN_CODE==null) MAIL_RES_TOWN_CODE="";
			MAIL_RES_TOWN_DESC=rset.getString("MAIL_RES_TOWN_DESC");
			 if(MAIL_RES_TOWN_DESC==null) MAIL_RES_TOWN_DESC="";
			MAIL_POSTAL_CODE=rset.getString("MAIL_POSTAL_CODE");
			 if(MAIL_POSTAL_CODE==null) MAIL_POSTAL_CODE="";

			  MAIL_POSTAL_CODE_DESC=rset.getString("MAIL_POSTAL_CODE_DESC");
			 if(MAIL_POSTAL_CODE_DESC==null) MAIL_POSTAL_CODE_DESC="";

			MAIL_COUNTRY_CODE=rset.getString("MAIL_COUNTRY_CODE");
			 if(MAIL_COUNTRY_CODE==null) MAIL_COUNTRY_CODE="";
			MAIL_COUNTRY_NAME =rset.getString("MAIL_COUNTRY_NAME");
			 if(MAIL_COUNTRY_NAME==null) MAIL_COUNTRY_NAME="";

			alt_id1_exp_date = rset.getString("alt_id1_exp_date");		
			if (alt_id1_exp_date==null) alt_id1_exp_date="";
			alternateid = rset.getString("alt_id1_no");
			if (alternateid==null) alternateid="";
	
			alt_id2_exp_date = rset.getString("alt_id2_exp_date");
			if (alt_id2_exp_date==null) alt_id2_exp_date="";
			alternateid1 = rset.getString("alt_id2_no");
			if (alternateid1==null) alternateid1="";
			alt_id3_exp_date = rset.getString("alt_id3_exp_date");
			if (alt_id3_exp_date==null) alt_id3_exp_date="";
			alternateid3 = rset.getString("alt_id3_no");
			if (alternateid3==null) alternateid3="";

			alt_id4_exp_date = rset.getString("alt_id4_exp_date");
			if (alt_id4_exp_date==null) alt_id4_exp_date="";
			alternateid4 = rset.getString("alt_id4_no");
			if (alternateid4==null) alternateid4="";

			nationalid= rset.getString("national_id_no");
			if (nationalid==null) nationalid="";

			OTH_ALT_ID_NO= rset.getString("OTH_ALT_ID_NO");
			if (OTH_ALT_ID_NO==null) OTH_ALT_ID_NO="";
			OTH_ALT_TYPE= rset.getString("OTH_ALT_ID_TYPE");
			if (OTH_ALT_TYPE==null) OTH_ALT_TYPE="";
			String suffix=rset.getString("name_suffix");

			String gender=rset.getString("sex");

			String restelno=rset.getString("contact1_no");
			if(restelno==null)
				 restelno="";
			String othtelno=rset.getString("contact2_no");
			if(othtelno==null)
				 othtelno="";

			
			String name_prefix_oth_lang=rset.getString("NAME_PREFIX_LOC_LANG");
			if(name_prefix_oth_lang ==null) name_prefix_oth_lang="";
			String firstname_local_lang=rset.getString("FIRST_NAME_LOC_LANG");
			if(firstname_local_lang ==null) firstname_local_lang="";
			String secondname_local_lang=rset.getString("SECOND_NAME_LOC_LANG");
			if(secondname_local_lang ==null) secondname_local_lang="";
			String thirdname_local_lang=rset.getString("THIRD_NAME_LOC_LANG");
			if(thirdname_local_lang ==null) thirdname_local_lang="";
			String familyname_local_lang=rset.getString("FAMILY_NAME_LOC_LANG");
			if(familyname_local_lang ==null) familyname_local_lang="";
			String name_suffix_oth_lang	=rset.getString("NAME_SUFFIX_LOC_LANG");
			if(name_suffix_oth_lang ==null) name_suffix_oth_lang="";

			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rset.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rset.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rset.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rset.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rset.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rset.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rset.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rset.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rset.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rset.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rset.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rset.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rset.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rset.getString("alt_country_desc"));
			/*End*/


		if(!alt_id1_exp_date.equals(""))
	{
	 alt_id1_exp_date_display=DateUtils.convertDate(alt_id1_exp_date,"DMY","en",locale);
	}
	if(!alt_id2_exp_date.equals(""))
	{
	 alt_id2_exp_date_display=DateUtils.convertDate(alt_id2_exp_date,"DMY","en",locale);
	}
	if(!alt_id3_exp_date.equals(""))
	{
	 alt_id3_exp_date_display=DateUtils.convertDate(alt_id3_exp_date,"DMY","en",locale);
	}
	if(!alt_id4_exp_date.equals(""))
	{
	 alt_id4_exp_date_display=DateUtils.convertDate(alt_id4_exp_date,"DMY","en",locale);
	}

if(calledFor.equals("modify_appt"))
{
contact_reason_code=rset.getString("contact_reason_code");
			if(contact_reason_code ==null) contact_reason_code="";

reason_for_transfer=rset.getString("CONTACT_REASON");
			if(reason_for_transfer ==null) reason_for_transfer="";
receiving_date_time=rset.getString("RECEIVING_DATE_TIME");
			if(receiving_date_time ==null) receiving_date_time="";
if(!receiving_date_time.equals(""))
	{
	 receiving_date_time_display=DateUtils.convertDate(receiving_date_time,"DMYHM","en",locale);
	}
appt_remarks=rset.getString("APPT_REMARKS");
			if(appt_remarks ==null) appt_remarks="";
mode_of_contact=rset.getString("MODE_OF_CONTACT");
			if(mode_of_contact ==null) mode_of_contact="";
}
			java.util.Date date1 = rset.getDate("date_of_birth");

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			String dateofbirth=formatter1.format(date1);
			formatter1 = null;
			dateofbirth_greg = dateofbirth;
			
			dateofbirth=DateUtils.convertDate(dateofbirth,"DMY","en",locale);

			stmt3=conn.createStatement();

			//for wt list

			if(calledFor.equals("WaitList")){

				 appt_num = rset.getString("BOOKING_REF_NO");
				

				String sqlappt= "select APPT_REMARKS, clinic_code, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_SHORT_DESC, RECEIVING_DATE_TIME, (SELECT VISIT_TYPE_IND FROM OP_VISIT_TYPE WHERE FACILITY_ID = '"+facilityid+"' AND VISIT_TYPE_CODE = APPT_TYPE_CODE) VISIT_TYPE_IND, REFERRAL_ID, NO_OF_SLOTS, CONTACT_REASON_CODE from oa_appt where appt_ref_no ='"+appt_num+"' and facility_id = '"+facilityid+"'";
				rsappt=stmt3.executeQuery(sqlappt);

				
				if(rsappt !=null && rsappt.next())
				{
					remarks=rsappt.getString("APPT_REMARKS");
					if(remarks ==null) remarks="";
					contact_rea=rsappt.getString("CONTACT_REASON");
					if(contact_rea ==null) contact_rea="";
					visit_type_desc=rsappt.getString("VISIT_TYPE_SHORT_DESC");
					if (visit_type_desc ==null) visit_type_desc="";
					recieve_date_time =rsappt.getString("RECEIVING_DATE_TIME");
					if (recieve_date_time ==null) recieve_date_time="";
					visit_ind=rsappt.getString("VISIT_TYPE_IND");
					if(visit_ind ==null) visit_ind="";
					ref_id_value=rsappt.getString("REFERRAL_ID");
					if(ref_id_value ==null) ref_id_value="";
					no_slots_val=rsappt.getInt("NO_OF_SLOTS");
					cont_res_code=rsappt.getString("CONTACT_REASON_CODE");
					if(cont_res_code ==null) cont_res_code="";
					appt_clinic_code=rsappt.getString("clinic_code");
					if(appt_clinic_code ==null) appt_clinic_code="";
					
				
				}
				String visit_type_code="";
				String sql_visit_type="select visit_type_code from op_visit_type_for_clinic_vw where facility_id='"+facilityid+"' and visit_type_short_desc ='"+visit_type_desc+"' and visit_type_ind ='"+visit_ind+"' and eff_status='E' and clinic_code='"+appt_clinic_code+"' and visit_type_ind != 'E'";

				rsappt_visit=stmt3.executeQuery(sql_visit_type);

				if(rsappt_visit !=null && rsappt_visit.next())
				{
					visit_type_code=rsappt_visit.getString("visit_type_code");
					if(visit_type_code ==null) visit_type_code="";
				}
				if(rsappt !=null) rsappt.close();
				if(rsappt_visit !=null) rsappt_visit.close();

				String sec_resources="";

				String sql_wait_sec  = "select resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+visit_type_code+"' and resource_class !='"+prm_res_class+"'  order by resource_class ";
						
				stmt_wait_sec=conn.createStatement();


				rs_wait_sec = stmt_wait_sec.executeQuery(sql_wait_sec);

				while(rs_wait_sec!=null && rs_wait_sec.next()){
					 sec_resources=sec_resources+rs_wait_sec.getString("resource_class");
					 sec_resources=sec_resources+"*"+rs_wait_sec.getString("resource_criteria")+"-";
				 }
				
				 if (rs_wait_sec!=null) rs_wait_sec.close();
				 if (stmt_wait_sec !=null) stmt_wait_sec.close();
				
				 if(sec_resources.length()>1)
					 sec_resources=sec_resources.substring(0,sec_resources.length()-1);
				
				 if(sec_resources.length()>1){
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sec_resources));
            _bw.write(_wl_block10Bytes, _wl_block10);
	

			}//wait list

			if(calledFor.equals("WaitList")  )
			{ 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_wtlt_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
 }

			// edn wt lst

			rs3=stmt3.executeQuery("select calculate_age('"+dateofbirth_greg+"',1) year ,calculate_age('"+dateofbirth_greg+"',2) month ,calculate_age('"+dateofbirth_greg+"',3) day from dual");
			rs3.next();
			String agey=rs3.getString("year");
			String agem=rs3.getString("month");
			String aged=rs3.getString("day");


			if (nationality_code!=""){
				if(!alcn_criteria_pop.equals("NG")){
					pat_cat_code = "*O";
				}	
			}else{
				pat_cat_code = "*O";
			}

			if(!patientid.equals("")){
				if(rs3!=null)rs3.close();
				rs3=stmt3.executeQuery("select PAT_CAT_CODE,mp_get_desc.MP_PAT_CATEGORY(PAT_CAT_CODE,'"+locale+"',2) pat_cat_desc from mp_patient where patient_id='"+patientid+"'");
				if(rs3!=null && rs3.next()){
					patient_cat_code=rs3.getString("PAT_CAT_CODE")==null?"":rs3.getString("PAT_CAT_CODE");
					patient_cat_desc=rs3.getString("pat_cat_desc")==null?"":rs3.getString("pat_cat_desc");
				}				
			}

			if(ref_priority!=null){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_priority));
            _bw.write(_wl_block14Bytes, _wl_block14);
	
			}
			
			
            _bw.write(_wl_block15Bytes, _wl_block15);
//=security_level
            _bw.write(_wl_block12Bytes, _wl_block12);

			if(patientid!=null){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
if(patientname!=null){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block0Bytes, _wl_block0);
if(patientname_local_lang!=null){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientname_local_lang));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patientname_local_lang));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(patient_long_name!=null){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_long_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
if(patient_long_name_loc_lang!=null){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_long_name_loc_lang));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
if(nationalid!=null) {
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nationalid));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else {
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(alternateid!=null) {
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alternateid));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
if(alt_id1_exp_date!=null) {
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_id1_exp_date_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
if(alternateid1!=null) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(alternateid1));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
if(alt_id2_exp_date!=null) {
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(alt_id2_exp_date_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
if(alternateid3!=null) {
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alternateid3));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
if(alt_id3_exp_date!=null) {
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(alt_id3_exp_date_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
if(alternateid4!=null) {
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alternateid4));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
if(alt_id4_exp_date!=null) {
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(alt_id4_exp_date_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
if(c_name_prefix_accept_yn.equals("Y")){
				if(prefix!=null) {
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(prefix));
            _bw.write(_wl_block59Bytes, _wl_block59);
}else {
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
 } 
            _bw.write(_wl_block27Bytes, _wl_block27);
 if(c_first_name_accept_yn.equals("Y")){ 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block63Bytes, _wl_block63);
 } 
            _bw.write(_wl_block27Bytes, _wl_block27);
 if(c_second_name_accept_yn.equals("Y")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block65Bytes, _wl_block65);
 } 
            _bw.write(_wl_block27Bytes, _wl_block27);
 if(c_third_name_accept_yn.equals("Y")){ 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block67Bytes, _wl_block67);
 } 
			/** Friday, February 12, 2010 IN000244 Start 
			*/
 
            _bw.write(_wl_block68Bytes, _wl_block68);
if(c_family_name_accept_yn.equals("Y")){ 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block70Bytes, _wl_block70);
 } 
            _bw.write(_wl_block71Bytes, _wl_block71);
 if(c_name_suffix_accept_yn.equals("Y")){
			if(suffix!=null) {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block12Bytes, _wl_block12);
 }else {
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block76Bytes, _wl_block76);

				if(name_prefix_oth_lang!=null) {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(name_prefix_oth_lang));
            _bw.write(_wl_block78Bytes, _wl_block78);
}else {
            _bw.write(_wl_block79Bytes, _wl_block79);
} /** END*/
            _bw.write(_wl_block80Bytes, _wl_block80);
	if(firstname_local_lang!=null) {
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(firstname_local_lang));
            _bw.write(_wl_block82Bytes, _wl_block82);
 }else {
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
	if(secondname_local_lang!=null) {
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(secondname_local_lang));
            _bw.write(_wl_block86Bytes, _wl_block86);
 }else {
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
	if(thirdname_local_lang!=null) {
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(thirdname_local_lang));
            _bw.write(_wl_block90Bytes, _wl_block90);
 }else {
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
	if(familyname_local_lang!=null) {
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(familyname_local_lang));
            _bw.write(_wl_block94Bytes, _wl_block94);
 }else {
            _bw.write(_wl_block95Bytes, _wl_block95);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 	if(name_suffix_oth_lang!=null) {
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(name_suffix_oth_lang));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(name_suffix_oth_lang));
            _bw.write(_wl_block98Bytes, _wl_block98);
 }else {
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(ADDR_LINE1));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(ADDR_LINE2));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(ADDR_LINE3));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(ADDR_LINE4));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(RES_TOWN_CODE));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(RES_TOWN_DESC));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(RES_AREA_CODE));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(RES_AREA_DESC));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(POSTAL_CODE));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(REGION_CODE));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(POSTAL_CODE_DESC));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(MAIL_POSTAL_CODE_DESC));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(REGION_DESC));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(COUNTRY_CODE));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(COUNTRY_NAME));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(MAIL_ADDR_LINE1));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(MAIL_ADDR_LINE2));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(MAIL_ADDR_LINE3));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(MAIL_ADDR_LINE4));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(MAIL_RES_TOWN_CODE));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(MAIL_RES_TOWN_DESC));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(MAIL_RES_AREA_CODE));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(MAIL_AREA_DESC));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(MAIL_POSTAL_CODE));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(MAIL_REGION_CODE));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(MAIL_REGION_DESC));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(MAIL_COUNTRY_CODE));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(MAIL_COUNTRY_NAME));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(CONTACT1_NO));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(CONTACT2_NO));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(EMAIL_ID));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(BIRTH_PLACE_CODE));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(birth_place_description));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(birth_place_description));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(NATIONALITY_CODE));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(NATIONALITY));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(CITIZEN_YN));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(LEGAL_ILLEGAL_YN));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(OTH_ALT_TYPE));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(OTH_ALT_ID_NO));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(ETHNIC_GRP_CODE));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(ETHNIC_GROUP_DESC));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(ETHNIC_GRP_CODE));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(ETHNIC_GRP_CODE));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(RACE_DESC));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(RACE_CODE));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(RACE_DESC));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(dateofbirth));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(patient_cat_code));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(patient_cat_code));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(patient_cat_desc));
            _bw.write(_wl_block170Bytes, _wl_block170);
if(calledFor.equals("modify_appt"))
			{
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(reason_for_transfer));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(receiving_date_time_display));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(appt_remarks));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(mode_of_contact));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block176Bytes, _wl_block176);
		

		if (!patientid.equals("")){
			

			String alt_status1 = patdata.CheckAlternateId(conn,patientid,locale);
			
			
				if(!alt_status1.equals(""))
			   {
				char val=alt_status1.charAt(0);
				
				if(val == 'W')
				{
					
					String val1=alt_status1.substring(2,alt_status1.length());
					out.println("var contyn = confirm(\""+val1+"\");  if(!contyn) clear_all_fun1('R');");
				}else if(val =='C')
				{			
					
						String val1=alt_status1.substring(1,alt_status1.length());
					out.println("alert(\""+val1+"\");clear_all_fun1('R');");
				}else 
				{
					
					String val1=alt_status1.substring(2,alt_status1.length());	out.println("alert(\""+val1+"\");");
				}
			}
		}
	}else{
		if (valid_patient){
            _bw.write(_wl_block177Bytes, _wl_block177);

		}
	}
}else{
	if(valid_patient){
            _bw.write(_wl_block178Bytes, _wl_block178);

	}
}
}
			}
if(rset !=null) rset.close();
}//referral
}
	if(rs3 !=null) rs3.close();
	if(c_rs != null) c_rs.close();
	if(rs != null) rs.close();
	if(rs12 !=null) rs12.close();
	if(rspat != null) rspat.close();
	if(rset_wtlt !=null)rset_wtlt.close();
	if(rsc_p != null) rsc_p.close();
	if(rset != null) rset.close();
	if(rsap != null) rsap.close();
	if(stmt != null) stmt.close();
	if(stmtap != null) stmtap.close();
	if(stmtpat != null) stmtpat.close();
	if(stmtc_p != null) stmtc_p.close();
	if(stmt3 != null) stmt3.close();
	if(c_stmtn !=null) c_stmtn.close();
	if(stmt12 !=null) stmt12.close();
	hash.clear();
}catch(Exception e) {
	String error = e.toString();
	error = error.replace('\n',',');
	
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(error));
            _bw.write(_wl_block180Bytes, _wl_block180);

}finally{
	
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
