package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __bookappointmentvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookAppointmentValidations.jsp", 1743071463595L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\nvar continueFlag = \"Y\";\nvar continue_yn = \'Y\';\nvar fromLookup = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\nfunction ClearValues()\n{\n\tparent.document.frames[1].document.forms[0].date_of_birth.readOnly = false;\n\tparent.document.frames[1].document.forms[0].b_age.readOnly = false;\n\tparent.document.frames[1].document.forms[0].b_months.readOnly = false;\n\tparent.document.frames[1].document.forms[0].b_days.readOnly = false;\n\tparent.document.frames[1].document.forms[0].nationality_code1.disabled = false;\n\tparent.document.frames[1].document.forms[0].sex.disabled = false;\n\n\tparent.document.frames[1].document.forms[0].alt_id1_type.value = \"\";\n\tparent.document.frames[1].document.forms[0].patient_name.value = \"\";\n\tparent.document.frames[1].document.forms[0].date_of_birth.value = \"\";\n\tparent.document.frames[1].document.forms[0].b_age.value = \"\";\n\tparent.document.frames[1].document.forms[0].b_months.value = \"\";\n\tparent.document.frames[1].document.forms[0].b_days.value = \"\";\n\tparent.document.frames[1].document.forms[0].nationality_code1.value = \"\";\n\tparent.document.frames[1].document.forms[0].nationality_desc.value = \"\";\n\tparent.document.frames[1].document.forms[0].sex.value = \"\";\n\tparent.document.frames[1].document.forms[0].race_code.value = \"\";\n\tif(\tparent.document.frames[1].document.forms[0].race_desc)\n\t\tparent.document.frames[1].document.forms[0].race_desc.value = \"\";\n\n\tif(parent.document.frames[1].document.forms[0].name_prefix1 != null)\n\t{\n\t   parent.document.frames[1].document.forms[0].name_prefix1.disabled = false;\n\t   parent.document.frames[1].document.forms[0].name_prefix1.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].first_name != null)\n\t{\n\t   parent.document.frames[1].document.forms[0].first_name.readOnly = false;\n\t   parent.document.frames[1].document.forms[0].first_name.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].second_name != null)\n\t{\n\t   parent.document.frames[1].document.forms[0].second_name.readOnly = false;\n\t   parent.document.frames[1].document.forms[0].second_name.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].third_name != null)\n\t{\n\t   parent.document.frames[1].document.forms[0].third_name.readOnly = false;\n\t   parent.document.frames[1].document.forms[0].third_name.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].family_name != null)\n\t{\n\t   parent.document.frames[1].document.forms[0].family_name.readOnly = false;\n\t   parent.document.frames[1].document.forms[0].family_name.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].name_suffix1 != null)\n\t{\n\t   parent.document.frames[1].document.forms[0].name_suffix1.disabled = false;\n\t   parent.document.frames[1].document.forms[0].name_suffix1.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].national_id_no)\n\t{\n\t\tparent.document.frames[1].document.forms[0].national_id_no.value = \"\";\n\t\tparent.document.frames[1].document.forms[0].national_id_no.disabled = false\n\t}\n\n\n\n\tif(parent.document.frames[1].document.forms[0].name_prefix_oth_lang != null)\n\t{\n\t\tparent.document.frames[1].document.forms[0].name_prefix_oth_lang.value = \"\";\n\t}\n\n\n\tif(parent.document.frames[1].document.forms[0].first_name_oth_lang != null)\n\t{\n\t\tparent.document.frames[1].document.forms[0].first_name_oth_lang.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].second_name_oth_lang != null)\n\t{\n\t\tparent.document.frames[1].document.forms[0].second_name_oth_lang.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].third_name_oth_lang != null)\n\t{\n\t\tparent.document.frames[1].document.forms[0].third_name_oth_lang.value = \"\";\n\t}\n\n\tif(parent.document.frames[1].document.forms[0].family_name_oth_lang != null)\n\t{\n\t\tparent.document.frames[1].document.forms[0].family_name_oth_lang.value = \"\";\n\t}\n\n\n\tif(parent.document.frames[1].document.forms[0].name_suffix_oth_lang != null)\n\t{\n\t\tparent.document.frames[1].document.forms[0].name_suffix_oth_lang.value = \"\";\n\t}\n}\n\nfunction DispalyValues(patinetid,referral_id)\n{\n\t\n\tvar CA_Pat = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\tif(referral_id != \"\")\n\t{\n\t\tvar HTMLVal1 = new String();\n\t\tHTMLVal1 = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form2\' id=\'form2\' method=\'post\' action=\'../jsp/BookApptCheckForNat.jsp\'><input type=\'hidden\' name=\'step\' id=\'step\' value=\'first\'><input name=\'referral_id\' id=\'referral_id\' type=\'hidden\' value=\\\"\"+referral_id+\"\\\"></form></form></BODY></HTML>\";\n\t\tparent.document.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal1);\n\t\tparent.document.frames[2].document.forms[0].submit();\n\t\t\n\t\tparent.document.frames[1].document.forms[0].referral_id.readOnly = true;\n\t\tparent.document.frames[1].document.forms[0].referral_details.disabled = true;\n\t\n\t}\n\telse\n\t{\n\t\t\n\t\tvar HTMLVal1 = new String();\n\t\tHTMLVal1 = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form2\' id=\'form2\' method=\'post\' action=\'../jsp/BookAppointmentValues.jsp\'><input type=\'hidden\' name=\'step\' id=\'step\' value=\'P\'><input name=\'pat_id1\' id=\'pat_id1\' type=\'hidden\' value=\\\"\"+patinetid+\"\\\"><input name=\'CA_Pat\' id=\'CA_Pat\' type=\'hidden\' value=\\\"\"+CA_Pat+\"\\\"></form></BODY></HTML>\";\n\t\tparent.document.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal1);\n\t\t\n\t\tparent.document.frames[2].document.form2.submit();\n\n\t}\n}\n\n</script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar error = getMessage(\"MORE_ALT_ID_FOUND\",\'common\')\n\t\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\");\n\t\t\t\t\talert(error);\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alternate_id.value=\'\';\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alternate_id.focus();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar err = getMessage(\"INVALID_VALUE\",\'common\');\n\t\t\t\t\terr = err.replace(\'#\',\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\");\n\t\t\t\t\talert(err);\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alternate_id.value=\'\';\n\t\t\t\t\tparent.document.frames[1].document.forms[0].alternate_id.focus();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"INV_REF_ID\",\'IP\'));\n\t\t\t\t\tfromLookup = \"Y\";\n\t\t\t\t\tcontinue_yn = \'N\';\n\t\t\t\t\tcontinueFlag = \'N\';\n\t\t\t\t\tparent.document.frames[1].document.forms[0].referral_id.value=\"\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].referral_id.focus();\n\t\t\t\t\tClearValues();\n\t\t\t\t\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\t\n\t\t\talert(getMessage(\"PAT_DECEASED_NOT_ALLOWED\",\"MP\"));\n\t\t\t\n\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].referral_id.value=\"\";\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\tcontinue_yn = \'N\';\n\t\t\tcontinueFlag = \'N\';\n\t\t\tClearValues();\n\t\t\tparent.document.frames[1].document.forms[0].referral_details.disabled = false;\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].referral_id.disabled = false;  // Added by Suresh M on 22.July.2010 for IN022827\n\t\t\tparent.document.frames[1].document.forms[0].referral_id.focus();\n\t\t\t\n\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script >\n\t\t\t\n\t\t\tvar err_age2 = getMessage( \"PAT_SUSPENDED_NOT_ALLOWED\",\"MP\");\n\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\tClearValues();\n\t\t\talert(err_age2);\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.focus();\n\t\t\tparent.window.reset();\n\t\t\tif(parent.document.frames[1].document.forms[0].referral_id)\t\n\t\t\t\tparent.document.frames[1].document.forms[0].referral_id.value=\"\";\n\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\tcontinue_yn = \'N\';\n\t\t\tcontinueFlag = \'N\';\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.focus();\n\t\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script >\n\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\tClearValues();\n\t\t\tvar err_age3 = getMessage( \"PAT_INACTIVE_NOT_ALLOWED\",\"MP\" ) ;\n\t\t\talert(err_age3);\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.focus();\n\t\t\t\t\n\t\t\tparent.window.reset();\n\t\t\t\n\n\t\t\t\n\t\t\tif(parent.document.frames[1].document.forms[0].referral_id)\t\n\t\t\t\tparent.document.frames[1].document.forms[0].referral_id.value=\"\";\n\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\tcontinue_yn = \'N\';\n\t\t\tcontinueFlag = \'N\';\n\t\t\tClearValues();\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.focus();\n\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<script>\n\t\t\t\n\t\t\talert(getMessage(\"INVALID_PATIENT\",\"MP\"));\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\'\';\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.focus();\n\t\t\tparent.document.frames[1].document.forms[0].patient_id.select();\n\t\t\tcontinue_yn = \'N\';\n\t\t\tcontinueFlag = \'N\';\n\t\t\tClearValues();\n\t\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar error= getMessage( \"PATIENT_MERGED_VALID\",\"MP\");\n\t\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");\n\t\t\t\t\talert(error);\t\n\t\t\t\t\tcontinue_yn = \'N\';\n\t\t\t\t\tcontinueFlag = \'N\';\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.focus();\n\t\t\t\t\tparent.document.frames[1].document.forms[0].patient_id.select();\n\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t\t<script>\n\t\t\t\n\t\t\tvar err_age3 = getMessage( \"ALT_ID_EXPIRED_CONFIRM\",\"MP\");\n\t\t\terr_age3 = err_age3.replace(\'$\',\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\");\n\t\t\tvar p = confirm(err_age3);\t\n\n\t\t\tif (!p)\t\n\t\t\t{\n\t\t\t\tparent.window.reset();\n\n\t\t\t}\n\t\t\telse DispalyValues(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\");\n\t\t\t </script> \n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t\t<script>\n\t\t\t\t\n\t\t\t\tvar msg = getMessage(\'ALT_ID_EXPIRED\',\'MP\');\n\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");\n\t\t\t\talert(msg);\t\n\t\t\t\tDispalyValues(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\n\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t\t<script>\n\t\t\t\t\n\t\t\t\tvar msg = getMessage(\'ALT_ID_EXPIRED\',\'MP\')\n\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" \n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar err_age3 = getMessage( \"ALT_ID_EXP_WITH_GRACE\",\"MP\");\n\t\t\t\t\terr_age3 = err_age3.replace(\'$\',\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");\n\t\t\t\t\talert(err_age3);\t\n\t\t\t\t </script> \n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXPIRED\',\'MP\')\n\t\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXPIRED\',\'MP\')\n\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\");\n\t\t\t\t\talert(msg);\n\t\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\");\n\t\t\t\t\talert(msg);\n\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" \n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar err_age3 = getMessage( \"ALT_ID_EXP_WITHIN\",\"MP\");\n\t\t\t\t\terr_age3 = err_age3.replace(\'$\',\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\");\n\t\t\t\t\talert(err_age3+\" \"+\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \"+getLabel(\"Common.days.label\",\"Common\"));\t\n\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXP_WITHIN\',\"MP\");\n\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\");\n\t\t\t\t\talert(msg+\" \"+\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" <script>\n\t\t\t\t\n\t\t\t\tvar msg = getMessage(\'ALT_ID_EXP_WITHIN\',\"MP\")\n\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\");\n\t\t\t\talert(msg+\" \"+\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \"+getLabel(\"Common.days.label\",\"Common\"));\t\n\t\t\t</script> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" \n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tvar msg = getMessage(\'ALT_ID_EXP_WITHIN\',\"MP\")\n\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \"+getLabel(\"Common.days.label\",\"Common\"));\t\n\t\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\n\t\t\t<script>\n\n\t\tif (continue_yn != \'N\')\n\t\t{\n\t\t\t\tDispalyValues(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\");\n\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<script>\n\t\tasync function bookAppointMentvalidation(){\n\t\tvar Unregpatbkgyn = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\tvar step = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\n\t\tif(fromLookup ==\"N\"  && step!=\"Alternate\")\n\t\t{\n\t\t\tif(Unregpatbkgyn == \"N\")\n\t\t\t{\n\t\t\tvar referral_id = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\n\t\t\tvar retVal =    new String();\n\t\t\tvar dialogHeight= \"50vh\" ;\n\t\t\tvar dialogWidth = \"40vw\" ;\n\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments   = \"\" ;\n\t\t\t\n\t\t\tretVal = await window.showModalDialog(\"../../eMP/jsp/VisitRegistrationPromptPatID.jsp?func_act=REF_SEARCH&q_from_funct=IP_ADMISSION&calledFrom=Booking&Unregpatbkgyn=\"+Unregpatbkgyn+\"&p_referral_id=\"+referral_id,arguments,features);\n\t\t\t}\n\t\t\n\t\tif(retVal!=null) \n\t\t{\t\n\t\t\tif(retVal!=\'C\' && retVal!=\'undefined\')\n\t\t\t{\t\n\t\t\t\t//parent.frames[1].document.booking_form.patient_id.value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t/*Above line commented and below line Added for this incident [IN043737]*/\n\t\t\t\tparent.frames[1].document.booking_form.patient_id.value=retVal;\n\t\t\t\tparent.frames[1].document.booking_form.med_service_grp.focus();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getMessage( \"ALLOW_UNREGISTERED\",\"IP\"));\n\t\t\t\tparent.frames[1].document.booking_form.referral_id.value =\'\';\n\t\t\t\tcontinueFlag = \"N\";\n\t\t\t\tparent.frames[1].document.booking_form.pref_adm_date.focus();\n\t\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{  \n\t\t\tif(Unregpatbkgyn == \"Y\")\n\t\t\t{\n\t\t\t\tif(retVal!= undefined)\t // if condition added on 26-09-2003 by dhanasekaran\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.booking_form.patient_id.value=retVal;\n\t\t\t\t\tparent.frames[1].document.booking_form.med_service_grp.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse{\n\t\t\t\n\t\t\talert(getMessage( \"ALLOW_UNREGISTERED\",\"IP\"));\n\t\t\tparent.frames[1].document.booking_form.referral_id.value =\'\';\n\t\t\tcontinueFlag = \"N\";\n\t\t\tparent.frames[1].document.booking_form.pref_adm_date.focus();\n\t\t\t\n\t\t\t}\n\t\t}\n\t}\n}\n\t\tbookAppointMentvalidation();\n\t</script>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t  <script>\n\tif(continueFlag == \"Y\")\n\t{\n\t\tvar HTMLVal1 = new String();\n\t\tHTMLVal1 = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form3\' id=\'form3\' method=\'post\' action=\'../jsp/BookApptCheckForNat.jsp\'><input type=\'hidden\' name=\'step\' id=\'step\' value=\'first\'><input name=\'referral_id\' id=\'referral_id\' type=\'hidden\' value=\\\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\\\"></form></form></BODY></HTML>\";\n\t\tparent.document.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal1);\n\t\tparent.document.frames[2].document.form3.submit();\n\t}\n\t </script>\t\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n<script>\nfunction  enableNatId1(callobj)\n{\n\tif(callobj == \"Apply\")\n\t{\n\t\tvarBodyFrame = \"f_query_add_mod.document\";\n\t}\n\telse\n\t{\n\t\tvarBodyFrame = \"parent.document.frames[1]\";\n\t}\n\tif(eval(varBodyFrame+\".document.getElementById(\"birth_place\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"birth_place\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"ethnic_group\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"ethnic_group\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"place_of_birth\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"place_of_birth\")\").disabled = false;\n\t/*\n\tif(eval(varBodyFrame+\".document.getElementById(\"race_code\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").disabled = false;\n\t*/\n\tif(eval(varBodyFrame+\".document.getElementById(\"race_desc\")\") != null) {\n\t\teval(varBodyFrame+\".document.getElementById(\"race_desc\")\").disabled = false;\n\t\teval(varBodyFrame+\".document.getElementById(\"race_desc_id\")\").disabled = false;\n\t}\n\n\tif(eval(varBodyFrame+\".document.getElementById(\"patient_name\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"patient_name\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"name_prefix1\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"name_prefix1\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"name_prefix\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"name_prefix\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"first_name\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"first_name\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"second_name\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"second_name\")\").disabled = false\n\tif(eval(varBodyFrame+\".document.getElementById(\"third_name\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"third_name\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"family_name\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"family_name\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"name_suffix1\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"name_suffix1\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"name_suffix\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"name_suffix\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"sex\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"sex\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"b_age\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"b_age\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"b_months\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"b_months\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"b_days\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"b_days\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"dob\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"dob\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"nationality_code1\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"nationality_code1\")\").disabled = false\n\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\").disabled = false;\t\t\n\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[1]\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[1]\").disabled = false;\t\n\tif(eval(varBodyFrame+\".document.getElementById(\"national_id_no\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"national_id_no\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\").disabled = false;\t\t\t\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\").disabled = false;\t\n\tif(eval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\").disabled = false;\n\tif(eval(varBodyFrame+\".document.getElementById(\"other_alt_Id\")\") != null)\n\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_Id\")\").disabled = false;\n\treturn true;\n}\n\n</script>\n</html>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);


request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
String CA_Pat			= request.getParameter("CA_Pat");
String Unregpatbkgyn	= request.getParameter("Unregpatbkgyn");
String fromLookup		= request.getParameter("fromLookup");
String locale			= (String)session.getAttribute("LOCALE");
boolean continue_yn		= true;

if(fromLookup == null)		fromLookup		= "N";
if(Unregpatbkgyn == null)	Unregpatbkgyn	= "N";
if(CA_Pat == null)			CA_Pat			= "N";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(fromLookup));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CA_Pat));
            _bw.write(_wl_block4Bytes, _wl_block4);

webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Connection conn = null;
String facilityID=(String)session.getValue("facility_id");
String loginUser = (String)session.getValue("login_user");
ResultSet rs	= null;
ResultSet rs_p	= null;
ResultSet rset1	= null;
Statement stmt	= null;
Statement stmt1	= null;
Statement stmt1_p = null;
Statement stmta = null;
Statement stmtb = null;
StringBuffer sqlQuery = new StringBuffer();
String cont_yn = "Y";
int cnt = 0;

try{
		conn = ConnectionManager.getConnection(request);
		String patientid = request.getParameter("pat_id");
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");

		String step			= checkForNull(request.getParameter("step"));
		String alternateid	= checkForNull(request.getParameter("alt_id"));
		String referral_id	= checkForNull(request.getParameter("referral_id"));
		String step1		= checkForNull(request.getParameter("step1"));
		if(step1.equals("PatientClass"))
		{
			
			String patientClass = request.getParameter("patClass");
			String p_oper_stn_id = request.getParameter("p_oper_stn_id");
			String medservdesc   = "";
			String medservcode   = "";
			String generatenumyn = "";
			String app_pat_class = "";
			out.println("<script>");
			out.println("var obj =parent.document.frames[1].document.forms[0].med_service_grp;");
			out.println("var length  = obj.length;");
			out.println("for(i=0;i<length;i++) {obj.remove(1);}");

			sqlQuery.append(" select distinct IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(FACILITY_ID,med_ser_grp_code,'"+locale+"','2') med_ser_grp_short_desc, med_ser_grp_code, generate_num_yn, APPL_PATIENT_CLASS FROM IP_MED_SER_GRP_NURS_UT_TYPE_VW where facility_id = '"+facilityID+"' and nursing_unit_type_code IN(SELECT DISTINCT nursing_unit_type_code FROM IP_NURSING_UNIT a, am_os_user_locn_access_vw b WHERE a.facility_id='"+facilityID+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.locn_code AND b.oper_stn_id='"+p_oper_stn_id+"' AND b.appl_user_id='"+loginUser+"' AND b.admit_pat_yn='Y' and a.locn_type=b.locn_type AND A.EFF_STATUS='E') AND eff_status = 'E' and appl_patient_class = '"+patientClass+"' order by med_ser_grp_short_desc  ");
			try
			{
				stmt = conn.createStatement();
				rs	 = stmt.executeQuery(sqlQuery.toString());
			
       			if( rs != null )
				{
					while( rs.next() )
	  				{
					 
						 medservdesc   = rs.getString("med_ser_grp_short_desc") ;
						 medservcode   = rs.getString("med_ser_grp_code") ;	
						 generatenumyn = rs.getString("generate_num_yn") ;  
						 app_pat_class = rs.getString("APPL_PATIENT_CLASS") ;	
						
						String strTmp  = medservcode+"#"+generatenumyn+"#"+app_pat_class;
						
						out.println ("var opt= parent.document.frames[1].document.createElement('Option');\nopt.text=\""+medservdesc+"\"; opt.value=\""+strTmp+"\";\nobj.add(opt)") ;
						out.println ("parent.document.frames[1].document.createElement('Option')") ;
 					}
				out.println("</script>");
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
       		}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{	
		if(step.equals("Alternate"))
		{
			
			String alt_id_prompt = checkForNull(request.getParameter("alt_id_prompt"));
			stmt	= conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select count(*) as total from mp_patient where alt_id1_no='"+alternateid+"' ");
			rs = stmt.executeQuery(sqlQuery.toString());
			if(rs !=null && rs.next())
			cnt = rs.getInt("total");
			if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			if(cnt > 1) 
			{
			
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(alt_id_prompt));
            _bw.write(_wl_block6Bytes, _wl_block6);

			}
			else if(cnt == 0) 
			{
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(alt_id_prompt));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			else if(cnt == 1) 
			{
				patientid = "";
				stmt = conn.createStatement();
				if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select patient_id from mp_patient where alt_id1_no='"+alternateid+"'");
				rs = stmt.executeQuery(sqlQuery.toString());
				if(rs != null && rs.next())
				patientid = rs.getString("patient_id");
				if(rs != null)rs.close();if(stmt !=null) stmt.close();
			}
		}

		if(step.equals("Referral"))
		{
			String qryString = request.getParameter("qryString");
			session.putValue( "queryString", qryString ) ;
			patientid = "";
			stmt = conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select count(*) as total from pr_referral_register where referral_id ='"+referral_id+"' and REFERRED_FOR_IP= 'B' and STATUS = 'O' ");/*added status for IN016586*/
			/*Tuesday, July 13, 2010 , To_Facility_Id = '"+facilityId+"' added in where criteria for SRR20056-SCF-4837 [IN:022644]*/
			sqlQuery.append (" and To_Facility_Id = '"+facilityID+"'");
			rs = stmt.executeQuery(sqlQuery.toString());
			if(rs != null && rs.next())
			cnt = rs.getInt("total");
			if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			if(cnt == 0) 
			{
				cont_yn = "N";
			
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			else
			{
				stmt = conn.createStatement();
				if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select patient_id from  pr_referral_register where referral_id ='"+referral_id+"' and REFERRED_FOR_IP= 'B'");
				rs = stmt.executeQuery(sqlQuery.toString());
				if(rs != null && rs.next())
				patientid = checkForNull(rs.getString("patient_id"));
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			}
		}

if(!patientid.equals("")) 
{
	String chkst=patdata.CheckStatus(conn,patientid);
	if(chkst.equals("DECEASED")) 
	{
		continue_yn = false;
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		patientid = ""; 
		
	}
	if(chkst.equals("SUSPENDED"))
		
	{
		continue_yn = false;
	
            _bw.write(_wl_block11Bytes, _wl_block11);


		patientid = ""; 
	
	}
	if(chkst.equals("INACTIVE")) 
	{
		continue_yn = false;

            _bw.write(_wl_block12Bytes, _wl_block12);

		
		patientid = ""; 
		
	}
	if(chkst.equals("INVALID_PATIENT")) 
	{
		continue_yn = false;

            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	if (chkst.indexOf("PATIENT_MERGED_VALID")>=0 )
	{
		continue_yn = false;
				StringTokenizer token=new StringTokenizer(chkst,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
		
	}
	if(continue_yn == true)
	{
		String alt_status = patdata.CheckAlternateId(conn,patientid,locale);

		  char alt_stat = 'Y';
		  if (alt_status.equals("alt_id1_expired") && alt_stat != 'N')
		  {
			alt_stat = 'N';
			stmt = conn.createStatement() ;
			rs = stmt.executeQuery("select alt_id1_type from mp_param");
			String altid_type  = "";
			if( rs != null && rs.next())
			altid_type = rs.getString("alt_id1_type");
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(altid_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block20Bytes, _wl_block20);

				 if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		  }
		  else if (alt_status.equals("alt_id2_expired") && alt_stat != 'N')
		  {
				stmt = conn.createStatement() ;
				rs = stmt.executeQuery("select alt_id2_type from mp_param");
				rs.next();
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			alt_stat = 'N';
		  }
		  else if (alt_status.equals("alt_id3_expired") && alt_stat != 'N')
		  {
			//continue_yn = 'N';
			stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id3_type from mp_param");
			rs.next();
			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			alt_stat = 'N';
		  }
		  else if (alt_status.equals("alt_id4_expired") && alt_stat != 'N')
		  {
			stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id4_type from mp_param");
			rs.next();
			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

				if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			alt_stat = 'N';
		  }
 
		  if (alt_stat!='N'&& alt_status!="")
		  {
				if (alt_status.indexOf("ALT_ID1_IN_GRACE")>=0)
				{
				alt_stat = 'N';
				stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id1_type from mp_param");
			rs.next();
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
	
					 if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
				}
				else if (alt_status.indexOf("ALT_ID2_IN_GRACE")>=0 && alt_stat != 'N')
				{
					stmt1_p = conn.createStatement() ;
					rs_p = stmt1_p.executeQuery("select alt_id2_type from mp_param");
					rs_p.next();
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs_p.getString(1)));
            _bw.write(_wl_block28Bytes, _wl_block28);

					if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
					alt_stat = 'N';
				}		
				else if (alt_status.indexOf("ALT_ID3_IN_GRACE")>=0 && alt_stat != 'N')
				{
					stmt1_p = conn.createStatement() ;
					rs_p = stmt1_p.executeQuery("select alt_id3_type from mp_param");
					rs_p.next();
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rs_p.getString(1)));
            _bw.write(_wl_block30Bytes, _wl_block30);

					if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
					alt_stat = 'N';
				}		
				else if (alt_status.indexOf("ALT_ID4_IN_GRACE")>=0 && alt_stat != 'N')
				{
					stmt1_p = conn.createStatement() ;
					rs_p = stmt1_p.executeQuery("select alt_id4_type from mp_param");
					rs_p.next();
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rs_p.getString(1)));
            _bw.write(_wl_block31Bytes, _wl_block31);

					if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
					alt_stat = 'N';
			  }		
		}

		if (alt_stat!='N'&& alt_status!="")
		{
			if (alt_status.indexOf("ALT_ID1_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				alt_stat = 'N';
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				alt_stat='N';
				stmt1 = conn.createStatement() ;
			rs = stmt1.executeQuery("select alt_id1_type from mp_param");
			rs.next();
			
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block34Bytes, _wl_block34);

				if(rs !=null) rs.close(); if(stmt1 != null) stmt1.close();
			}
			else if (alt_status.indexOf("ALT_ID2_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1_p = conn.createStatement() ;
				rs_p = stmt1_p.executeQuery("select alt_id2_type from mp_param");
				rs_p.next();
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rs_p.getString(1)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block34Bytes, _wl_block34);

				if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
				alt_stat = 'N';
			}		
			else if (alt_status.indexOf("ALT_ID3_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1_p = conn.createStatement() ;
				rs_p = stmt1_p.executeQuery("select alt_id3_type from mp_param");
				rs_p.next();
			
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs_p.getString(1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block39Bytes, _wl_block39);

				if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
				alt_stat = 'N';
			}		
			else if (alt_status.indexOf("ALT_ID4_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1_p = conn.createStatement() ;
				rs_p = stmt1_p.executeQuery("select alt_id4_type from mp_param");
				rs_p.next();
				
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rs_p.getString(1)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(days1));
            _bw.write(_wl_block41Bytes, _wl_block41);

				if(rs_p !=null) rs_p.close(); if(stmt1_p != null) stmt1_p.close();
				alt_stat = 'N';
			}		
		}

		

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
		
	}
}
else
{	
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(step));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block48Bytes, _wl_block48);

	
}
if(step.equals("Referral") && cont_yn.equals("Y"))
{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
}
}
catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();}
finally
{
	if(rs != null) rs.close();	
	if(rs_p != null) rs_p.close();	
	if(rset1 != null) rset1.close();	
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt1_p !=null) stmt1_p.close();
	if(stmta !=null) stmta.close();
	if(stmtb !=null) stmtb.close();
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block52Bytes, _wl_block52);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
