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
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __bookappointmentvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookAppointmentValues.jsp", 1709117718863L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\t\t\t\n\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].patient_name.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].patient_name.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\tparent.document.frames[1].document.forms[0].national_id_no.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\tparent.document.frames[1].document.forms[0].national_id_no.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\tparent.document.frames[1].document.forms[0].national_id_no.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.readOnly=true;\n\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.value=\'\';\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\tparent.document.frames[1].document.forms[0].first_name.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\tparent.document.frames[1].document.forms[0].first_name.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\tparent.document.frames[1].document.forms[0].first_name.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\tparent.document.frames[1].document.forms[0].second_name.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\tparent.document.frames[1].document.forms[0].second_name.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\tparent.document.frames[1].document.forms[0].second_name.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\tparent.document.frames[1].document.forms[0].third_name.value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\tparent.document.frames[1].document.forms[0].third_name.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\tparent.document.frames[1].document.forms[0].third_name.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\tparent.document.frames[1].document.forms[0].family_name.value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\tparent.document.frames[1].document.forms[0].family_name.value=\'\';\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\tparent.document.frames[1].document.forms[0].family_name.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\tparent.document.frames[1].document.forms[0].name_suffix1.value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\tparent.document.frames[1].document.forms[0].name_suffix1.value=\'\';\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\tparent.document.frames[1].document.forms[0].name_suffix1.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\tparent.document.frames[1].document.forms[0].sex.value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\n\t\t\tparent.document.frames[1].document.forms[0].sex.disabled=true;\n\t\t\tparent.document.frames[1].document.forms[0].date_of_birth.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].date_of_birth.readOnly=true;\n\t\t\t\n\t\t\tparent.document.frames[1].document.getElementById(\"dob\").disabled=true;\n\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].b_age.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].b_age.readOnly=true;\n\t\t\tparent.document.frames[1].document.forms[0].b_months.value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].b_months.readOnly=true;\n\t\t\tparent.document.frames[1].document.forms[0].b_days.value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].b_days.readOnly=true;\n\t\t\tparent.document.frames[1].document.forms[0].nationality_code1.value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].nationality_code1.disabled = true;\n\t\t\tif(\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" != \"\")\n\t\t\t\n\t\t\tif(\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" == \"Y\" && parent.document.frames[1].document.getElementById(\"pref_adm_date\"))\n\t\t\t\tparent.document.frames[1].document.getElementById(\"pref_adm_date\").focus();\t\n\t\t\telse if(parent.document.frames[1].document.getElementById(\"chief_complaint\"))\n\t\t\t\tparent.document.frames[1].document.getElementById(\"chief_complaint\").focus();\t\n\t</script>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\"\";\n\t\t\t\t\t\t\talert(getMessage(\"PAT_DECEASED_NOT_ALLOWED\",\"MP\"));\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t<script >\n\n\t\t\t\t\t\tvar err_age2 = getMessage( \"PAT_SUSPENDED_NOT_ALLOWED\",\"MP\" ) ;\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\"\";\n\t\t\t\t\t\talert(err_age2);\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\"\";\n\t\t\t\t\t\tvar err_age3 = getMessage( \"PATIENT_INACTIVE\",\"MP\" ) ;\n\t\t\t\t\t\talert(err_age3);\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_name.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_name.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].national_id_no.readOnly=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\'\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.readOnly=true;\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"; \n\t \n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.value=\'\';\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.disabled=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].first_name.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].first_name.value=\'\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].first_name.readOnly=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].second_name.value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].second_name.value=\'\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].second_name.readOnly=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].third_name.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].third_name.value=\'\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].third_name.readOnly=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].family_name.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].family_name.value=\'\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].family_name.readOnly=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_suffix1.value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_suffix1.disabled=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n\t\t\t\t\tparent.document.frames[1].document.forms[0].sex.value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].sex.disabled=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].date_of_birth.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].date_of_birth.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.getElementById(\"dob\").disabled=true;\n\t\t\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_age.value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_age.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_months.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_months.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_days.value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_days.readOnly=true;\n\n\t\t\t\t\tparent.document.frames[1].document.forms[0].nationality_code1.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"\n\t\t\t\t\tparent.document.frames[1].document.forms[0].nationality_code1.disabled = true;\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" != \"\")\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t</script>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"MANY_ALT_ID_FOUND\",\"IP\"));\n\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\'\';\n\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_PAT_FOR_ALT_ID\",\"IP\"));\n\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\'\';\n\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.value=\"\";\n\t\t\t\t\t\talert(getMessage(\"PAT_DECEASED_NOT_ALLOWED\",\"MP\"));\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<script>\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_name.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].national_id_no.value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].national_id_no.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_no.readOnly=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_prefix1.value=\'\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].first_name.readOnly=true;\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\tparent.document.frames[1].document.forms[0].name_suffix1.value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].date_of_birth.readOnly=true;\n\t\t\t\t\t\n\t\t\t\t\tparent.document.frames[1].document.getElementById(\"dob\").disabled=true;\n\t\t\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_age.value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].b_days.readOnly=true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].nationality_code1.value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].nationality_code1.disabled = true;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\t\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" != \"\")\n\t\t\t\t\tparent.document.frames[1].document.getElementById(\"alt_id_exp_dt1\").innerHTML=com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.expiryDate.label\",\"common_labels\")+\"&nbsp;&nbsp;\";\n\t\t\t\t\tparent.document.frames[1].document.getElementById(\"alt_id_exp_dt1\").innerHTML=\"<b>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</b>\";\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

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

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection conn		= null;
	Statement stmt		= null;
	Statement stmt2		= null;
	ResultSet rset		= null;			
	ResultSet rs2		= null;

	String altid1expdate			= "";
	String c_name_prefix_accept_yn	= "";
	String c_first_name_accept_yn	= "";
	String c_second_name_accept_yn	= "";
	String c_third_name_accept_yn	= "";
	String c_family_name_accept_yn	= "";
	String c_name_suffix_accept_yn	= "";
	StringBuffer sqlQuery = new StringBuffer();
	try
	{
		conn	= ConnectionManager.getConnection(request);
		stmt	= conn.createStatement();
		sqlQuery.append("select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param");
		rset	= stmt.executeQuery(sqlQuery.toString());
		if(rset != null && rset.next())
		{
			c_name_prefix_accept_yn		= rset.getString("name_prefix_accept_yn");
			c_first_name_accept_yn		= rset.getString("first_name_accept_yn");
			c_second_name_accept_yn		= rset.getString("second_name_accept_yn");
			c_third_name_accept_yn		= rset.getString("third_name_accept_yn");
			c_family_name_accept_yn		= rset.getString("family_name_accept_yn");
			c_name_suffix_accept_yn		= rset.getString("name_suffix_accept_yn");
		}

		if(rset!=null)		rset.close();
		if(stmt!=null)		stmt.close();

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam2' id='nam2'>");

		int c=0;

		String step		= request.getParameter("step");
		String CA_Pat	= request.getParameter("CA_Pat");

		if(step.equals("P"))
		{
			String patientid	= request.getParameter("pat_id1");
			stmt				= conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("SELECT patient_name,national_id_no,alt_id1_no,name_prefix,");
			sqlQuery.append("first_name,second_name,third_name,family_name,name_suffix,sex,to_char(date_of_birth,'dd/mm/rrrr') dateofbirth,");
			sqlQuery.append("b.ADDR1_LINE1 resi_addr_line1,b.ADDR1_LINE2 resi_addr_line2,b.ADDR1_LINE3 resi_addr_line3,");
			sqlQuery.append(" b.ADDR1_LINE4 resi_addr_line4,b.POSTAL1_CODE resi_postal_code,");
			sqlQuery.append(" b.COUNTRY1_CODE resi_country_code,contact1_no prn_tel_no,contact2_no ");
			sqlQuery.append(" orn_tel_no,alt_id1_type,email_id,nationality_code,TO_CHAR(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date, ");
			sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1) agey,"); 
			sqlQuery.append(" calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),2) agem, ");
			sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),3) aged ");
			sqlQuery.append(" FROM MP_PATIENT A, MP_PAT_ADDRESSES b WHERE A.patient_id ='"+patientid+"' AND A.PATIENT_ID = b.PATIENT_ID ");
			rset=stmt.executeQuery(sqlQuery.toString());
			if(rset!=null && rset.next()) 
			{
				String patientname		= checkForNull(rset.getString("patient_name"));
				String nationalid		= checkForNull(rset.getString("national_id_no"));
				String alternateid		= checkForNull(rset.getString("alt_id1_no"));
				String prefix			= checkForNull(rset.getString("name_prefix"));
				String firstname		= checkForNull(rset.getString("first_name"));	 
				String secondname		= checkForNull(rset.getString("second_name")); 
				String thirdname		= checkForNull(rset.getString("third_name"));	 
				String familyname		= checkForNull(rset.getString("family_name")); 
				String suffix			= checkForNull(rset.getString("name_suffix"));
				String gender			= checkForNull(rset.getString("sex"));
				String dateofbirth		= checkForNull(rset.getString("dateofbirth"));
				String agey				= checkForNull(rset.getString("agey"));
				String agem				= checkForNull(rset.getString("agem"));
				String aged				= checkForNull(rset.getString("aged"));
				String nationalitycode	= checkForNull(rset.getString("nationality_code"));
					   altid1expdate	= checkForNull(rset.getString("alt_id1_exp_date"));
				

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(nationalid!=null) {
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nationalid));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
			else {
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
if(alternateid!=null) {
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alternateid));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
			else {
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

			if(c_name_prefix_accept_yn.equals("Y"))
			{
			if(prefix!=null) {
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(prefix));
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
			else {
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(c_first_name_accept_yn.equals("Y"))
			{
			if(firstname!=null) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
			else {
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(c_second_name_accept_yn.equals("Y"))
			{
			if(secondname!=null) {
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
			else {
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(c_third_name_accept_yn.equals("Y"))
			{
			if(thirdname!=null) {
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
			else {
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
if(c_family_name_accept_yn.equals("Y"))
			{
			if(familyname!=null) {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
			else {
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(c_name_suffix_accept_yn.equals("Y"))
			{
			if(suffix!=null) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(suffix));
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
			else {
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
 } 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dateofbirth));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nationalitycode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(altid1expdate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(CA_Pat));
            _bw.write(_wl_block46Bytes, _wl_block46);


		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
	}
	else if(step.equals("N")) 
	{
		String nationalid	=request.getParameter("nat_id");
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select national_id_no from mp_patient");
		stmt2	= conn.createStatement();
		rs2		= stmt.executeQuery(sqlQuery.toString());
		java.util.Date date3	= rset.getDate("date_of_birth");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/rrrr");

		while(rs2.next()) 
		{
			if(rs2.getString("national_id_no") !=null) 
			{
				String nnvalue	= rs2.getString("national_id_no");

				if(nnvalue.equals(nationalid)) 
				{
					if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
					sqlQuery.append("select patient_id,decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name,alt_id1_no,name_prefix,first_name,second_name,third_name,family_name,");
					sqlQuery.append("name_suffix,sex,date_of_birth,contact1_no prn_tel_no,contact2_no orn_tel_no,");
					sqlQuery.append(" email_id,nationality_code,to_char(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date, ");
					sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1) agey, ");
					sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),2) agem, ");
					sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),3) aged from mp_patient where national_id_no='"+nationalid+"' ");
					rset= stmt.executeQuery(sqlQuery.toString());
					if(rset !=null) 
					{
					rset.next();
					String patientid=rset.getString("patient_id");
					webbeans.op.PatientData patdata = new webbeans.op.PatientData();

					String chkst=checkForNull(patdata.CheckStatus(conn,patientid));
					

					if(chkst.equals("DECEASED")) 
					{
					
            _bw.write(_wl_block47Bytes, _wl_block47);

					}
					else if(chkst.equals("SUSPENDED"))
					{
					
            _bw.write(_wl_block48Bytes, _wl_block48);

				}
				else if(chkst.equals("INACTIVE")) 
				{
			
            _bw.write(_wl_block49Bytes, _wl_block49);

				}
				else 
				{
					if(patientid != null )
					{
						String patientname		= checkForNull(rset.getString("patient_name"));	
						String altid			= checkForNull(rset.getString("alt_id1_no"));																					
						String namepref			= checkForNull(rset.getString("name_prefix"));
						String firstname		= checkForNull(rset.getString("first_name"));
						String secondname		= checkForNull(rset.getString("second_name"));
						String thirdname		= checkForNull(rset.getString ("third_name"));
						String familyname		= checkForNull(rset.getString("family_name"));
						String namesuffix		= checkForNull(rset.getString("name_suffix"));
						String gender			= checkForNull(rset.getString("sex"));
						String nationalitycode	= checkForNull(rset.getString("nationality_code"));
						altid1expdate			= checkForNull(rset.getString("alt_id1_exp_date"));
						date3	= rset.getDate("date_of_birth");
						//SimpleDateFormat 
						formatter2 = new SimpleDateFormat("dd/MM/rrrr");
						String dateofbirth		= formatter2.format(date3);
							   formatter2		= null;

						String agey				= checkForNull(rset.getString("agey"));
						String agem				= checkForNull(rset.getString("agem"));
						String aged				= checkForNull(rset.getString("aged"));

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block52Bytes, _wl_block52);
 if(altid!=null) {
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(altid));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block55Bytes, _wl_block55);
 }
            _bw.write(_wl_block56Bytes, _wl_block56);

					if(c_name_prefix_accept_yn.equals("Y"))
					{
					 if(namepref!=null) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(namepref));
            _bw.write(_wl_block58Bytes, _wl_block58);
 }
					else {
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_first_name_accept_yn.equals("Y"))
					{
					if(firstname!=null) {
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_second_name_accept_yn.equals("Y"))
					{
					if(secondname!=null) {
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block66Bytes, _wl_block66);
 }
					else {
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_third_name_accept_yn.equals("Y"))
					{
					if(thirdname!=null) {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
if(c_family_name_accept_yn.equals("Y"))
					{
					if(familyname!=null) {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_name_suffix_accept_yn.equals("Y"))
					{
					if(namesuffix!=null) {
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block76Bytes, _wl_block76);
 }
					else {
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
 } 
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dateofbirth));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(nationalitycode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(altid1expdate));
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block86Bytes, _wl_block86);

				}  // end of else
			} // end of rset	 
		}
		}
		}	// end of while
	}
	if(rset != null) rset.close();
	if(rs2 != null) rs2.close();
	if(stmt != null) stmt.close();
	if(stmt2 != null) stmt2.close();
	else if(step.equals("A")) 
	{
		String alternateid	= request.getParameter("alt_id");
		stmt	= conn.createStatement();
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select count(*) as total from mp_patient where alt_id1_no='"+alternateid+"' ");
		rset	= stmt.executeQuery(sqlQuery.toString());
		if(rset != null && rset.next())
		c		= rset.getInt("total");
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(c>1) 
		{
		
            _bw.write(_wl_block87Bytes, _wl_block87);

		}
		else if(c==0) 
		{
		
            _bw.write(_wl_block88Bytes, _wl_block88);

		}
		else if(c==1) 
		{
			stmt	= conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select patient_id,decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name,national_id_no,name_prefix,first_name,second_name,");
			sqlQuery.append("third_name,family_name,name_suffix,sex,to_char(date_of_birth,'dd/mm/rrrr') dateofbirth, contact1_no prn_tel_no,contact2_no orn_tel_no,email_id, ");
			sqlQuery.append(" nationality_code, TO_CHAR(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date, ");
			sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1) agey,"); sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),2) agem,"); sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),3) aged from mp_patient where ");
			sqlQuery.append("alt_id1_no='"+alternateid+"' ");
			rset	= stmt.executeQuery(sqlQuery.toString());
			if(rset != null) 
			{
				rset.next();
				String patientid	= rset.getString("patient_id");

				webbeans.op.PatientData patdata = new webbeans.op.PatientData();

				String chkst		= patdata.CheckStatus(conn,patientid);

				if(chkst.equals("DECEASED")) 
				{
				
            _bw.write(_wl_block89Bytes, _wl_block89);

				}
				else if(chkst.equals("SUSPENDED"))
				{
				
            _bw.write(_wl_block48Bytes, _wl_block48);

				}
				else if(chkst.equals("INACTIVE")) 
				{
			
            _bw.write(_wl_block49Bytes, _wl_block49);

				}
				else 
				{
					String patientname		= checkForNull(rset.getString("patient_name"));
					String natid			= checkForNull(rset.getString("national_id_no"));		
					String namepref			= checkForNull(rset.getString("name_prefix"));
					String firstname		= checkForNull(rset.getString("first_name"));
					String secondname		= checkForNull(rset.getString("second_name"));
					String thirdname		= checkForNull(rset.getString("third_name"));
					String familyname		= checkForNull(rset.getString("family_name"));
					String namesuffix		= checkForNull(rset.getString("name_suffix"));
					String gender			= checkForNull(rset.getString("sex"));
					String nationalitycode	= checkForNull(rset.getString("nationality_code"));
					altid1expdate			= checkForNull(rset.getString("alt_id1_exp_date"));
					String dateofbirth1		= checkForNull(rset.getString("dateofbirth"));
					String agey				= checkForNull(rset.getString("agey"));
					String agem				= checkForNull(rset.getString("agem"));
					String aged				= checkForNull(rset.getString("aged"));

	
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(natid));
            _bw.write(_wl_block92Bytes, _wl_block92);

					if(c_name_prefix_accept_yn.equals("Y"))
					{
					if(namepref!=null) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(namepref));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block93Bytes, _wl_block93);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_first_name_accept_yn.equals("Y"))
					{
					if(firstname!=null) {
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(firstname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_second_name_accept_yn.equals("Y"))
					{
					if(secondname!=null) {
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(secondname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_third_name_accept_yn.equals("Y"))
					{
					if(thirdname!=null) {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(thirdname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);
 } 
            _bw.write(_wl_block95Bytes, _wl_block95);
if(c_family_name_accept_yn.equals("Y"))
					{
					if(familyname!=null) {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(familyname));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
 }
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(c_name_suffix_accept_yn.equals("Y"))
					{
					if(namesuffix!=null) {
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(namesuffix));
            _bw.write(_wl_block54Bytes, _wl_block54);
 }
					else {
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
 } 
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dateofbirth1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(nationalitycode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(altid1expdate));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(altid1expdate));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(altid1expdate));
            _bw.write(_wl_block102Bytes, _wl_block102);
}
            _bw.write(_wl_block103Bytes, _wl_block103);

			} // e of rset2
		}
	}
if(rset != null) rset.close();
if(stmt != null) stmt.close();
}catch(Exception e) {//out.println(e.toString());
e.printStackTrace();
}
	finally
	{
		try{
		if(rset != null) rset.close();
		if(rs2 != null)	rs2.close();
		if(stmt2 != null) stmt2.close();
		if(stmt != null) stmt.close();
		ConnectionManager.returnConnection(conn,request);
		}catch(Exception ee) {
			//out.println("Error while Closing the connections :"+ee.toString());
			ee.printStackTrace();
			}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
