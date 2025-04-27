package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __duppatidcomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/DupPatIdComponent.jsp", 1709116504310L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\t\t\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t\t<Script src=\"../../eMP/js/DupnatAltIdComponent.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<script>\n\t\n\tfunction  enableNatId()\n\t\t{\n\t\t\tvarBodyFrame = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'\n\t\t\t\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"patient_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"patient_name\")\").disabled = false\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"name_prefix\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"name_prefix\")\").disabled = false\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"first_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"first_name\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"second_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"second_name\")\").disabled = false\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"third_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"third_name\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"family_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"family_name\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"name_suffix\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"name_suffix\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"sex\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"sex\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"b_age\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_age\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"b_months\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_months\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"b_days\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_days\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"dob\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"dob\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t//if(eval(varBodyFrame+\".document.getElementById(\"nationality_desc\")\") != null)\n\t\t\t\t//{\n\t\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"nationality_desc\")\").disabled = false\n\t\t\t\t//}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\").disabled = false;\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[1]\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[1]\").disabled = false;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"legal_yn\")[0]\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"legal_yn\")[0]\").disabled = false;\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"legal_yn\")[1]\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"legal_yn\")[1]\").disabled = false;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"national_id_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"national_id_no\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\").disabled = false;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\").disabled = false;\n\t\t\t\t}\n\t\t\treturn true;\n\n\t\t}\n\t\tfunction checkPatient(Obj)\n\t\t{\n\t\t\tvar op_call = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t//alert(op_call);\n\t\t\tif(!(Obj.value==\"\"))\n\t\t\t\t{\n\t\t\t\t validatePatient(Obj);\n\t\t\t\t  if(op_call == \"ae_reg_pat\")\n\t\t\t\t\t{\n\t\t\t\t\t eval(varBodyFrame+\".document.getElementById(\"patient_id\")\").readOnly=true;\n\t\t\t\t\t}\n\t\t\t\t \n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(op_call == \"OA\")\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\tclear_fun_all(\'FromOA\');\n\t\t\t\tclearAll();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\tclearAll();\n\t\t\t\t}\n\t\t}\n\t\tfunction checkforOA()\n\t\t{\n\t\t\tvar op_call = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\tif(op_call == \"OA\")\n\t\t\t\tclear_recur();\n\t\t}\n\t\tfunction clearAll()\n\t\t{\n\t\t\t\n\t\t\tvarBodyFrame = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n\t\t\t\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"sec_sel\")\") != null)\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"sec_sel\")\").value=\"\";\n\t\t\t\t\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"patient_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"patient_name\")\").disabled = false\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"patient_name\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"patient_name1\")\").innerHTML=\"\";\n\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"patient_name_local_lang1\")\").innerHTML=\"\";\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"name_prefix\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"name_prefix\")\").disabled = false\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"name_prefix\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"first_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"first_name\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"first_name\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"second_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"second_name\")\").disabled = false\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"second_name\")\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"third_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"third_name\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"third_name\")\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"family_name\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"family_name\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"family_name\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"name_suffix\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"name_suffix\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"name_suffix\")\").value = \"\";\n\t\t\t\t}\n\n\t\t\t\t\t// added for local lang names\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"first_name_oth_lang\") != null)\n\t\t\t\t{\n\t\t\t\teval(varBodyFrame).document.getElementById(\"first_name_oth_lang\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"first_name_oth_lang\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"second_name_oth_lang\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"second_name_oth_lang\").disabled = false\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"second_name_oth_lang\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"third_name_oth_lang\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"third_name_oth_lang\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"third_name_oth_lang\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"family_name_oth_lang\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"family_name_oth_lang\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"family_name_oth_lang\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"name_prefix_oth_lang\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_prefix_oth_lang\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_prefix_oth_lang\").value = \"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"name_suffix_oth_lang\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_suffix_oth_lang\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_suffix_oth_lang\").value = \"\";\n\t\t\t\t}\n\n\n\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"sex\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"sex\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"sex\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"date_of_birth\")\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"b_age\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_age\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_age\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"b_months\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_months\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_months\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"b_days\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_days\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_days\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"dob\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"dob\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"dob\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"birth_place\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"birth_place\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"birth_place\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"Birth_place_code\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"b_birth\")\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"place_of_birth\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"place_of_birth\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"place_of_birth\")\").value = \"\";\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"nationality_desc\")\"))\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"nationality_desc\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"nationality_id\")\").disabled = false;\n\t\t\t\t\t//Commented on 30.10.2004 for Malaysian Requiremnts\n\t\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"nationality_desc\")\").value = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t\t//eval(varBodyFrame+\".document.getElementById(\"nationality_code1\")\").value = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\t//Comments Ends\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t}\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"race_code\")\") != null)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar def_cd=eval(varBodyFrame+\".document.getElementById(\"default_race_code\")\").value;\n\t\t\t\t\tvar sel_cd=eval(varBodyFrame+\".document.getElementById(\"race_code\")\").value;\n\n\t\t\t\t\t\n\t\t\t\t\tif(def_cd==\'\'){\n\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").disabled = false\n\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").options[0].selected = true\n\t\t\t\t\t\t\n\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"ethnic_group\")\").disabled = false;\n\t\t\t\t\t\teval(varBodyFrame+\".loadEthnicSubGroup()\");\n\t\t\t\t\t}else{\t\t\n\t\t\t\t\t\tif(def_cd==sel_cd){\n\t\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").disabled = false\n\n\t\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").value=def_cd;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"ethnic_group\")\").disabled = false;\n\t\t\t\t\t\t\teval(varBodyFrame+\".loadEthnicSubGroup()\");\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").disabled = false\n\t\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"race_code\")\").options[0].selected = true\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"ethnic_group\")\").disabled = false;\n\t\t\t\t\t\t\teval(varBodyFrame+\".loadEthnicSubGroup()\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t}\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")\")!=null)\n\t\t\t\t{\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[0]\").checked = true;\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[1]\") != null)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"citizen_yn\")[1]\").disabled = false;\n\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"legal_yn\")[0]\") != null)\n\t\t\t\t{\n\t\t\t//\t\teval(varBodyFrame+\".document.getElementById(\"legal_yn\")[0]\").disabled = false;\teval(varBodyFrame+\".document.getElementById(\"legal_yn\")[0]\").checked = true;\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"legal_yn\")[1]\") != null)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t//\t\t\teval(varBodyFrame+\".document.getElementById(\"legal_yn\")[1]\").disabled = false;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"national_id_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"national_id_no\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"national_id_no\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_type\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_Id\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"other_alt_Id\")\").value = \"\";\n\t\t\t\t}\n\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\"))\n\t\t\t\t{\n\t\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id1_no\")\").value!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt1\")\").disabled = false;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\").disabled = true;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id1_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt1\")\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\"))\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id2_no\")\").value!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt2\")\").disabled = false;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\").disabled = true;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id2_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt2\")\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\"))\n\t\t\t\t{\n\n\t\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id3_no\")\").value!=\"\")\t\n\t\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt3\")\").disabled = false;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\").disabled = true;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id3_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt3\")\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\n\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\"))\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"alt_id4_no\")\").value!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\").disabled = false;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt4\")\").disabled = false;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\").disabled = true;\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id4_exp_date\")\").value = \"\";\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"alt_id_exp_dt4\")\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\n\n\t\t\tdocument.forms[0].addr1_type.value\t\t\t\t\t= \"\";  \n\t\t\tdocument.forms[0].addr_line1.value\t\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].addr_line2.value\t\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].addr_line3.value\t\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].addr_line4.value\t\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].res_town_code.value\t\t\t    = \"\";\n\t\t\tdocument.forms[0].res_area_code.value\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].postal_code.value\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].region_code.value\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].country_code.value\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].contact1_name.value\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].invalid1_yn.value\t\t\t\t    = \"\";\n\t\t\tdocument.forms[0].addr2_type.value\t\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].mail_addr_line1.value\t\t\t\t= \"\";\n\t\t\tdocument.forms[0].mail_addr_line2.value\t\t\t= \"\";\n\t\t\tdocument.forms[0].mail_addr_line3.value\t\t\t= \"\";\n\t\t\tdocument.forms[0].mail_addr_line4.value\t\t\t= \"\";\n\t\t\tdocument.forms[0].mail_res_town_code.value\t= \"\";\n\t\t\tdocument.forms[0].mail_res_area_code.value\t= \"\";\n\t\t\tdocument.forms[0].mail_postal_code.value\t    = \"\";\n\n\t\t\tdocument.forms[0].mail_region_code.value\t\t= \"\";\n\t\t\tdocument.forms[0].mail_country_code.value\t\t= \"\";\n\n\t\t\tdocument.forms[0].contact2_name.value\t\t=  \"\";\n\t\t\tdocument.forms[0].invalid2_yn.value\t\t=  \"\";\n\n\t\t\tdocument.forms[0].contact1_no.value\t\t=  \"\";\n\t\t\tdocument.forms[0].contact2_no.value\t\t=  \"\";\n\t\t\tdocument.forms[0].email.value\t\t=  \"\";\n\t\t\tdocument.forms[0].mail_country_desc.value\t\t=  \"\";\n\t\t\tdocument.forms[0].country_desc.value\t\t=  \"\";\n\t\t}\n\t\tfunction patSearch() \n\t\t{\t\t\t\t\n//\t\t\t\tvar patid=PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');\n\t\t\t\tvar patid=PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'N\',\'\',\'OTHER\');\n\t\t\t\tif( patid ==null)patid=\"\";\n\t\t\t\tif (patid != \"\")document.forms[0].patient_id.value=patid;\n\n\t\t\t\tif(patid != \"\" && patid !=null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"patient_id\")\").value = patid;\n\t\t\t\t\tvalidatePatient(eval(varBodyFrame+\".document.getElementById(\"patient_id\")\"));\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tclearAll();\n\t\t\t\t}\n\t\t}\n\n\t\tfunction validatePatient(obj) {\t\t\n\t\t\t\n\t\t\t//alert(\'MP funciton called\')\n\t\t\t\n\t\t\tvarSubmitFrame = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'\n\t\t\t\n\t\t\tvarBodyFrame = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\n\n\t\t\tvarAlertYn = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'\n\t\t\tvarDervnlogic = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n\t\t\tvarpartname = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\n\t\t\tvar vAltId1Type = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'\n\t\t\tvar vAltId2Type = \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'\n\t\t\tvar vAltId3Type = \'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'\n\t\t\tvar vAltId4Type = \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'\n\t\t\tvar vAcceptOtherAltId = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'\n\t\t\tif(eval(varBodyFrame+\".document.getElementById(\"sec_sel\")\") != null)\n\t\t\t\t\teval(varBodyFrame+\".document.getElementById(\"sec_sel\")\").value=\"\";\n\n\t\t\tvar op_call = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'\n\t\t\tif(op_call==\"reg_pat\"||op_call==\"ae_reg_pat\")\n\t\t\t\tvarSubmitFrame = \"parent.parent.frames[2]\";\n\t\t\tif(obj.value != \'\')\t{\n\t\t\t\tdocument.forms[0].change_address.value =\"N\";\n\t\t\t\tvar HTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMP/jsp/DupPatIdValidations.jsp\'><input type=\'hidden\' name=\'process_id\' id=\'process_id\' value=\'4\'><input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=\'\" +obj.value + \"\'><input type=\'hidden\' name=\'bodyFrame\' id=\'bodyFrame\' value=\'\"+varBodyFrame+\"\'><input type=\'hidden\' name=\'submitFrame\' id=\'submitFrame\' value=\'\"+varSubmitFrame+\"\'><input type=\'hidden\' name=\'name_dervn_logic\' id=\'name_dervn_logic\' value=\'\"+varDervnlogic+\"\'><input type=\'hidden\' name=\'alert_reqd_yn\' id=\'alert_reqd_yn\' value=\'\"+varAlertYn+\"\'><input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\'\"+varpartname+\"\'><input type=\'hidden\' name=\'AltId1Type\' id=\'AltId1Type\' value=\'\"+vAltId1Type+\"\'><input type=\'hidden\' name=\'AltId2Type\' id=\'AltId2Type\' value=\'\"+vAltId2Type+\"\'><input type=\'hidden\' name=\'AltId3Type\' id=\'AltId3Type\' value=\'\"+vAltId3Type+\"\'><input type=\'hidden\' name=\'AltId4Type\' id=\'AltId4Type\' value=\'\"+vAltId4Type+\"\'><input type=\'hidden\' name=\'AcceptOtherAltId\' id=\'AcceptOtherAltId\' value=\'\"+vAcceptOtherAltId+\"\'><input type=\'hidden\' name=\'op_call\' id=\'op_call\' value=\'\"+op_call+\"\'></form></BODY></HTML>\";\n\t\t\t\t\n//\t\t\teval(varSubmitFrame).document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\teval(varSubmitFrame).document.write(HTMLVal);\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\tif(eval(varSubmitFrame).document.form1!=null)\n\t\t\t\t{\n\t\t\t\teval(varSubmitFrame).document.form1.submit();\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(op_call != \"reg_pat\" && op_call != \"ae_reg_pat\")\n\t\t\t\tlocalValidations(obj.value);\n\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].change_address.value =\"Y\";\n\t\t\t\tif(document.getElementById(\"past_visits\"))\n\t\t\t\tdocument.forms[0].past_visits.disabled=true;\n\t\t\t\tif(document.getElementById(\"last_visits\"))\n\t\t\t\tdocument.forms[0].last_visits.disabled=true;\n\t\t\t\tif(document.getElementById(\"other_id1\"))\n\t\t\t\t\tdocument.getElementById(\"other_id1\").style.visibility=\'hidden\';\n\t\t\t\t\n\t\t\t\tclearAll();\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n<input type=\'hidden\' name=\'alert_reqd_yn\' id=\'alert_reqd_yn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'name_dervn_logic\' id=\'name_dervn_logic\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n   <!-- <table cellpadding=0 cellspacing=0 border=0 width=\"100%\" tabindex=-1>\n\t<tr>\n\t<td align=\'right\' class=\'label\' width=\'1.6%\' nowrap>Patient ID</td>\n\t<td nowrap width=\'1.8%\' align=\'left\'>\n\t&nbsp;&nbsp;<input type= \'text\' name=\'patient_id\' id=\'patient_id\' value=\"\" size=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  maxlength=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  onchange=\'ChangeUpperCase(this);checkPatient(this)\' onKeyPress=\'return CheckForSpecChars(event)\' ><input type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\"BUTTON\" onClick=\'patSearch()\' tabIndex=\"-1\" >\t\n\t</td>\n\t<td align=\'right\' class=\'label\' width=\"1%\" nowrap>&nbsp;Name&nbsp;</td>\n\t<td  width=\"5.4%\">&nbsp;<input type=\'text\' name=\'patient_name\' id=\'patient_name\'  maxlength=\'60\' size=\'60\' readonly></td>\n\t<td align=\'left\' width=\'1%\'>&nbsp;&nbsp;<input type=\'button\' class=\'button\' name=\'contact_details\' id=\'contact_details\' value=\'Contact Details\'  onclick=\'Modal_Contact_Details(this);\' id = \'\' style=\'width:100px\'>\n\t</td>\n</tr>\n</table> -->\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String strBodyFrame =  request.getParameter("bodyFrame");
	String strSubmitFrame = request.getParameter("submitFrame");

	String strAlertReqdYn = request.getParameter("alert_reqd_yn");
	String strNameDrvnLogic = request.getParameter("name_dervn_logic");
	String strPatNameAsMultiPart = request.getParameter("pat_name_as_multipart_yn");
	//added by gomathi to populate the alternate id values on 25/03/04
	String AltId1Type = request.getParameter("AltId1Type");
    String AltId2Type = request.getParameter("AltId2Type");
	String AltId3Type = request.getParameter("AltId3Type");
	String AltId4Type = request.getParameter("AltId4Type");
	String AcceptOtherAltId = request.getParameter("AcceptOtherAltId");
	String defaultncode = request.getParameter("defaultncode");
	String defaultndesc = request.getParameter("defaultndesc");
	String op_call = request.getParameter("op_call");
	
	if(op_call == null) op_call="";
	if(op_call.equals("reg_pat")||op_call.equals("ae_reg_pat"))
	  strBodyFrame = "parent.parent.frames[1].frames[0]";


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defaultndesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(defaultncode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strAlertReqdYn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strNameDrvnLogic));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strPatNameAsMultiPart));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(AltId1Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(AltId2Type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(AltId3Type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(AltId4Type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(AcceptOtherAltId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block25Bytes, _wl_block25);

	String strPatIdSize = request.getParameter("patidsize");
	if(strPatIdSize == null || strPatIdSize=="")
	{
		strPatIdSize = "0";
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strAlertReqdYn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strNameDrvnLogic));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strPatNameAsMultiPart));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strPatIdSize));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPatIdSize));
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
