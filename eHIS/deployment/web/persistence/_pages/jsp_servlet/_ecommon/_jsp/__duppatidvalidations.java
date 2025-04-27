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
import javax.servlet.http.*;
import javax.servlet.jsp.JspWriter;
import java.util.*;
import com.ehis.util.*;

public final class __duppatidvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/DupPatIdValidations.jsp", 1709116504514L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script>\nfunction get_message_text(message,prompt)\n{\n    var message_text;\n    message_text = getMessage(message);\n    return message_text;\n}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\tfunction clr_flds(){\n\n\t\t\tvar op_call = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'\n\t\t\tif(op_call==\"reg_pat\" || op_call==\"ae_reg_pat\")\n\t\t\t\tvarBodyFrame = \"parent.frames[1].frames[0]\";\n\t\t\telse\n\t\t\tvarBodyFrame = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\t\t\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_name\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_name\").value = \"\";\n\t\t\t\t\t//eval(varBodyFrame).document.getElementById(\"patient_name1\").innerHTML = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_name_local_lang\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_name_local_lang\").value = \"\";\n\t\t\t\t\t//eval(varBodyFrame).document.getElementById(\"patient_name_local_lang1\").innerHTML = \"\";\n\t\t\t\t}\n \n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"name_prefix\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_prefix\").disabled = false\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_prefix\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"first_name\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"first_name\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"first_name\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"second_name\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"second_name\").disabled = false\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"second_name\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"third_name\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"third_name\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"third_name\").value= \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"family_name\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"family_name\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"family_name\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"name_suffix\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_suffix\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"name_suffix\").value = \"\";\n\t\t\t\t}\n\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"sex\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"sex\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"sex\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"date_of_birth\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"date_of_birth\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"date_of_birth\").value= \"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"b_age\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"b_age\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"b_age\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"b_months\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"b_months\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"b_months\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"b_days\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"b_days\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"b_days\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"dob\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"dob\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"dob\").value = \"\";\n\t\t\t\t}\n\t\t\t\t\n\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"nationality_desc\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_desc\").disabled = false\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_desc\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_code1\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_id\").disabled = false\n\t\t\t\t\t\n\t\t\t\t}\n\n\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"nationality_desc\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_desc\").disabled = false\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_desc\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_code1\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_id\").disabled = false\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")!=null)\n\t\t\t\t{\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[0] != null)\n\t\t\t\t{\n\t\t\t\t\t//eval(varBodyFrame).document.getElementById(\"citizen_yn\")[0].checked = true;\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[1] != null)\n\t\t\t\t{\n//\t\t\t\t\teval(varBodyFrame).document.getElementById(\"citizen_yn\")[1].disabled = true;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"legal_yn\")[0] != null)\n\t\t\t\t{\n\t\t\t\t\t//eval(varBodyFrame).document.getElementById(\"legal_yn\")[0].checked = true;\t\t\n\t\t\t\t\t//eval(varBodyFrame).document.getElementById(\"legal_yn\").disabled = true;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"legal_yn\")[1] != null)\n\t\t\t\t{\n//\t\t\t\t\teval(varBodyFrame).document.getElementById(\"legal_yn\")[1].disabled = true;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"national_id_no\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"national_id_no\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"national_id_no\").value = \"\";\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id1_no\") != null)\n\t\t\t\t{\n\t\t\t\t\t/*if(eval(varBodyFrame).document.getElementById(\"alt_id1_no\"))\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").value = \"\";*/\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id2_no\") != null)\n\t\t\t\t{\n\t\t\t\t\t/*eval(varBodyFrame).document.getElementById(\"alt_id2_no\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id2_no\").value = \"\";*/\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id3_no\") != null)\n\t\t\t\t{\n\t\t\t\t\t/*eval(varBodyFrame).document.getElementById(\"alt_id3_no\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id3_no\").value = \"\";*/\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id4_no\") != null)\n\t\t\t\t{\n\t\t\t\t\t/*eval(varBodyFrame).document.getElementById(\"alt_id4_no\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id4_no\").value = \"\";*/\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt1\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt2\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\") != null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt3\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\")!= null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\").value = \"\";\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt4\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"other_alt_type\")!= null)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"other_alt_type\").disabled = false;\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"other_alt_type\").value = \"\";\n\t\t\t\t\t\n\t\t\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"other_alt_Id\"))\n\t\t\t{\n\t\t\t  eval(varBodyFrame).document.getElementById(\"other_alt_Id\").value = \"\";\n\t\t\t  eval(varBodyFrame).document.getElementById(\"other_alt_Id\").disabled = false;\n\t\t\t}\n\t  \t   \teval(varBodyFrame).document.forms[0].addr1_type.value\t\t\t\t\t= \"\";  \n\t\t\teval(varBodyFrame).document.forms[0].addr_line1.value\t\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].addr_line2.value\t\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].addr_line3.value\t\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].addr_line4.value\t\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].res_town_code.value\t\t\t    = \"\";\n\t\t\teval(varBodyFrame).document.forms[0].res_area_code.value\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].postal_code.value\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].region_code.value\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].country_code.value\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].contact1_name.value\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].invalid1_yn.value\t\t\t\t    = \"\";\n\t\t\teval(varBodyFrame).document.forms[0].addr2_type.value\t\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_addr_line1.value\t\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_addr_line2.value\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_addr_line3.value\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_addr_line4.value\t\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_res_town_code.value\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_res_area_code.value\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_postal_code.value\t    = \"\";\n\n\t\t\teval(varBodyFrame).document.forms[0].mail_region_code.value\t\t= \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_country_code.value\t\t= \"\";\n\n\t\t\teval(varBodyFrame).document.forms[0].contact2_name.value\t\t=  \"\";\n\t\t\teval(varBodyFrame).document.forms[0].invalid2_yn.value\t\t=  \"\";\n\n\t\t\teval(varBodyFrame).document.forms[0].contact1_no.value\t\t=  \"\";\n\t\t\teval(varBodyFrame).document.forms[0].contact2_no.value\t\t=  \"\";\n\t\t\teval(varBodyFrame).document.forms[0].email.value\t\t=  \"\";\n\t\t\teval(varBodyFrame).document.forms[0].mail_country_desc.value\t\t=  \"\";\n\t\t\teval(varBodyFrame).document.forms[0].country_desc.value\t\t=  \"\";\n\t\t\t}\n</script>\n\n\n<script>\nvarBodyFrame = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t\t\t\t\nvar prev_set_objs = new Array() ;\nfunction putPatientName()   {\n\n/*    var logic = new String();\n   \n\n    logic = document.getElementById(\"strNameDrvnLogic_one\").value;\n    var derivedName = new String();\n    derivedName = \'\';\n    var logicElements = new Array();\n\tif(logic !=\"\")\n\t{\n    logicElements = logic.split(\'!\');\n\t}\n    var i=0;\n\n    for ( i=0;i<logicElements.length;i++)\n    {\n        if ( logicElements[i] == \'1N\' && eval(varBodyFrame).document.getElementById(\"first_name\") != null)\n        {\n            if ( eval(varBodyFrame).document.getElementById(\"first_name\").value != \'\' )\n                derivedName = derivedName + eval(varBodyFrame).document.getElementById(\"first_name\").value;\n        }\n        else if ( logicElements[i] == \'2N\' && eval(varBodyFrame).document.getElementById(\"second_name\") != null )\n        {\n            if ( eval(varBodyFrame).document.getElementById(\"second_name\").value != \'\' )\n                derivedName = derivedName + eval(varBodyFrame).document.getElementById(\"second_name\").value;\n        }\n        else if ( logicElements[i] == \'3N\' && eval(varBodyFrame).document.getElementById(\"third_name\") != null)\n        {\n            if ( eval(varBodyFrame).document.getElementById(\"third_name\").value != \'\' )\n                derivedName = derivedName + eval(varBodyFrame).document.getElementById(\"third_name\").value;\n        }\n        else if ( logicElements[i] == \'FN\' && eval(varBodyFrame).document.getElementById(\"family_name\") != null)\n        {\n\t\t\t\n            if ( eval(varBodyFrame).document.getElementById(\"family_name\").value != \'\' )\n                derivedName = derivedName + eval(varBodyFrame).document.getElementById(\"family_name\").value;\n        }\n        else if ( logicElements[i] == \'PR\' && eval(varBodyFrame).document.getElementById(\"name_prefix\") != null)\n        {\n\t\t\t\n            if ( eval(varBodyFrame).document.getElementById(\"name_prefix\").value != \'\' )\n                derivedName = derivedName + eval(varBodyFrame).document.getElementById(\"name_prefix\").value;\n        }\n        else if ( logicElements[i] == \'SF\' && eval(varBodyFrame).document.getElementById(\"name_suffix\") != null)\n        {\n            if ( eval(varBodyFrame).document.getElementById(\"name_suffix\").value != \'\' )\n                derivedName = derivedName + eval(varBodyFrame).document.getElementById(\"name_suffix\").value;\n        }\n        else\n        {\n            if ( logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\' )\n            {\n                var arLen = logicElements[i].length;\n                var tempVal = logicElements[i].substring(1,arLen - 1);\n                derivedName = derivedName + tempVal;\n            }\n        }\n    }\n\tif (eval(varBodyFrame).document.getElementById(\"pat_name_as_multipart_yn\").value==\"Y\")\n\t{\n\t\tif ( derivedName.length >= 40 )\n\t\t\tderivedName = derivedName.substr(0,40);\t\t\t\n\t}\n\telse\n\t{\n\t\tif ( derivedName.length >= 60 )\n\t\t\tderivedName = derivedName.substr(0,60);\n\t}\n\tvar derievedName1 = derivedName.split(\',\');\n\tif(derievedName1[1] == \' \')\n\t{\n\t\tderivedName = \tderievedName1[0];\n\t}\n   \n\teval(varBodyFrame).document.getElementById(\"patient_name1\").innerHTML = \"<b>\"+derivedName;\n\teval(varBodyFrame).document.getElementById(\"patient_name\").value =derivedName;\n\t*/\t\n}\n</script>\n<input type=\'hidden\' name=\'alert_reqd_yn\' id=\'alert_reqd_yn\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\'hidden\' name=\'strNameDrvnLogic_one\' id=\'strNameDrvnLogic_one\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n    <input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n<!-- @Get the Patient Id and Check the Status of the Patient -->\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<!-- @SQL Query Used -->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n<script>\nvarBodyFrame = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\nvar op_call = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\nif(op_call==\"reg_pat\" || op_call == \"ae_reg_pat\")\n  varBodyFrame = \"parent.frames[1].frames[0]\"\nvar invFlg=\'F\';\n\nvar varFlag = true;\nvarSubmitFrame = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'\nif(op_call == \"reg_pat\" || op_call ==\"ae_reg_pat\")\n  varSubmitFrame = \"parent.frames[2]\"\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\talert(getMessage(\'BLACKLISTED_PATIENT\',\'MP\'));\n\t\t\t\tvarFlag = false;\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t}\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\talert(getMessage(\'PAT_SUSPENDED_NOT_ALLOWED\',\'MP\'));\n\t\t\t\tvarFlag = false;\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t}\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\talert(getMessage(\'PAT_DECEASED_NOT_ALLOWED\',\'MP\'));\n\t\t\t\tvarFlag = false;\t\t\t\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t}\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\talert(getMessage(\'PAT_INACTIVE_NOT_ALLOWED\',\'MP\'));\t\t\t\t\n\t\t\t\tvarFlag = false;\t\t\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t}\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\tinvFlg=\'T\';\n\t\t\t\tvarFlag = false;\n\t\t\t\t\n\t\t\t\talert(getMessage(\'INVALID_PATIENT\',\'MP\'));\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\n\t\t\t\tvarFlag = false;\n\t\t\t\tvar error= getMessage( \"PATIENT_MERGED_VALID\" ,\'MP\');\n\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\");\t\t\t\t\n\t\t\t\talert(error);\t\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t{\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t}\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t                                eval(varBodyFrame).focus();\n\t\t\t\t\tvar err_age3 = getMessage(\"CURRENTLY_IN_PATIENT\",\'common\');\n\t\t\t\t\talert(err_age3);\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\tif (eval(varBodyFrame).document.getElementById(\"nat_gif_nat_gif\"))\n\t\teval(varBodyFrame).document.getElementById(\"nat_gif_nat_gif\").style.visibility = \'hidden\';\n\tif (eval(varBodyFrame).document.getElementById(\"nat_gif_yn\"))\n\t\teval(varBodyFrame).document.getElementById(\"nat_gif_yn\").value = \'N\'\n\tif (eval(varBodyFrame).document.getElementById(\"eth_gif\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"eth_gif\").style.visibility=\'hidden\';\n\tif (eval(varBodyFrame).document.getElementById(\"eth_gif_yn\"))\n\t\teval(varBodyFrame).document.getElementById(\"eth_gif_yn\").value = \'N\'\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\nif(!((eval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\")) == null))\n{\n\teval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\").value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n}\nif(!((eval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\")) == null))\n{\n\teval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\").value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"\n}\nif(!((eval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\")) == null))\n{\n\teval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\").value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\n}\nif(!((eval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\")) == null))\n{\n\teval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\").value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"\n}\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n var obj = eval(varBodyFrame).document.getElementById(\"other_alt_type\").options;\n\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t{\n\t\t\t\tif(obj.options[k].value == \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\")\n\t\t\t\t\tobj.options[k].selected = true;\n\t\t}\n\n eval(varBodyFrame).document.getElementById(\"other_alt_Id\").value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\tif(varFlag == true)\n\t\t{  \n\t\t\tif(\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" == \'W\')\n\t\t\t{\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\tvar ret = confirm(\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\");\n\t\t\t\t\tif(!ret)\n\t\t\t\t\t{\n\t\t\t\t\t\tvarFlag = false;\n\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n\t\t\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\n\t\t\t\t\t}\n\t\t\t}else if(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" ==\'C\')\n\t\t\t{";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\tvarFlag = false;\n\t\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\");\n\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").value = \"\";\n\t\t\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t\t\t\t}\n\t\t\t}else\n\t\t\t{";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\");\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" == \"1\")\n\t\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"\n\t\t\t\t\t\telse if(\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" == \"2\")\n\t\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" == \"3\")\n\t\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").value = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" == \"4\")\n\t\t\t\t\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"\n\t\t\t}\n\t   }\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n<!-- @Check forthe Citlzenship -->\n\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")!=null)\n\t\t{\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[0])\n\t\t\t\teval(varBodyFrame).document.getElementById(\"citizen_yn\")[0].disabled = false;\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[1])\n\t\t\t\teval(varBodyFrame).document.getElementById(\"citizen_yn\")[1].disabled = false;\n\t\t}\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\t\t\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"eth_gif\")!=null)\n\t\t\teval(varBodyFrame).document.getElementById(\"eth_gif\").style.visibility=\'visible\'\n\t\t\teval(varBodyFrame).document.getElementById(\"race_yn\").value = \'Y\';\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")!=null)\n\t\t\t{\n\t\t\t//eval(varBodyFrame).document.getElementById(\"citizen_yn\")[0].checked = true; \n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t//eval(varBodyFrame).document.getElementById(\"legal_yn\")[0].checked = true;\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t//eval(varBodyFrame).document.getElementById(\"legal_yn\")[1].checked = true;\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t}\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"eth_gif\")!=null)\n\t\t\teval(varBodyFrame).document.getElementById(\"eth_gif\").style.visibility=\'hidden\'\t\n\t\t\teval(varBodyFrame).document.getElementById(\"race_yn\").value = \'N\';\t\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")!=null)\n\t\t\t{\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[1])\n\t\t\t\t\teval(varBodyFrame).document.getElementById(\"citizen_yn\")[1].checked = true;\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"legal_yn\")[0])\n\t\t\t\t\t//eval(varBodyFrame).document.getElementById(\"legal_yn\")[0].checked = true;\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"legal_yn\")[1])\n\t\t\t\t//eval(varBodyFrame).document.getElementById(\"legal_yn\")[1].checked = true;\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\t\t\t\n\t\t\t}\n\t\t\t\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n<!-- @Check Legal -->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\teval(varSubmitFrame).document.location.href = \'../../eCommon/jsp/error.jsp?err_value=0\';\n\n\tif(varFlag == false)\n\t{\n\t\tif(invFlg==\'T\'){\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"birth_place\")!=null){\n\t\t\t\teval(varBodyFrame).document.getElementById(\"birth_place\").value = \"\";\n\t\t\t\teval(varBodyFrame).document.getElementById(\"Birth_place_code\").value = \"\";\n\t\t\t\teval(varBodyFrame).document.getElementById(\"b_birth\").disabled = false;\n\t\t\t\teval(varBodyFrame).document.getElementById(\"eth_gif\").style.visibility=\'visible\';\t\n\t\t\t}\n\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"nationality_desc\")!=null){\n\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_id\").disabled = false;\n\t\t\t}\n\t\t\t\n\t\t\t\n\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"race_code\")!=null){\n\t\t\t\teval(varBodyFrame).document.getElementById(\"race_code\").disabled = false;\n\t\t\t\teval(varBodyFrame).document.getElementById(\"race_code\").options[0].selected = true\n\n\t\t\t\teval(varBodyFrame).document.getElementById(\"ethnic_group\").disabled = false\n\t\t\t\teval(varBodyFrame).document.getElementById(\"ethnic_group\").options[0].selected = true\n\t\t\t}\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"patient_id\").readOnly == false && eval(varBodyFrame).document.getElementById(\"patient_id\").disabled == false)\n\t\t\t{\n\t\t\t\teval(varBodyFrame).document.getElementById(\"patient_id\").focus();\n\t\t\t}\n\t\t\t\n\t\t\tclr_flds();\n\t\t}else{\n\t\t\t\tclr_flds();\n\t\t}\n\t}\n\telse\n\t{\n\n\t\teval(varBodyFrame).document.getElementById(\"addr1_type\").value = \"\"\n\t\teval(varBodyFrame).document.getElementById(\"addr_line1\").value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"addr_line2\").value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"addr_line3\").value = \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"addr_line4\").value = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"res_town_code\").value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"res_town_desc\").value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"res_area_code\").value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"res_area_desc\").value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"postal_code\").value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"r_postal_code_desc\").value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"region_code\").value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"region_desc\").value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"country_code\").value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"country_desc\").value = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"contact1_name\").value = \"\"\n\t\teval(varBodyFrame).document.getElementById(\"invalid1_yn\").value = \"\"\n\t\teval(varBodyFrame).document.getElementById(\"addr2_type\").value = \"\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_addr_line1\").value = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_addr_line2\").value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_addr_line3\").value = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_addr_line4\").value = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_res_town_code\").value = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_res_town_desc\").value = \"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_res_area_code\").value = \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_res_area_desc\").value = \"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_postal_code\").value = \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"m_postal_code_desc\").value = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_region_code\").value = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_region_desc\").value = \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_country_code\").value = \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"mail_country_desc\").value = \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"contact2_name\").value = \"\"\n\t\teval(varBodyFrame).document.getElementById(\"invalid2_yn\").value = \"\"\n\t\teval(varBodyFrame).document.getElementById(\"contact1_no\").value =\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"contact2_no\").value =\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"email\").value =\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"\n\t\tif(eval(varBodyFrame).document.getElementById(\"Birth_place_code\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"Birth_place_code\").value =\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"\n\t\tif(eval(varBodyFrame).document.getElementById(\"place_of_birth\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"place_of_birth\").value =\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"\n\t\tif(eval(varBodyFrame).document.getElementById(\"birth_place\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"birth_place\").value = \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"\n\t\t\n\t\tif(eval(varBodyFrame).document.getElementById(\"name_prefix\") != null)\n\t\t{\t\t\t\n\t\t\tvar obj = eval(varBodyFrame).document.getElementById(\"name_prefix\");\t\t\t\n\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t{\n\t\t\t\t\tif(obj.options[k].value == \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\tobj.options[k].selected = true;\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t}\n\t\t\teval(varBodyFrame).document.getElementById(\"name_prefix\").disabled = true\n\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"race_code\") != null)\n\t\t{\t\t\t\n\t\t\tvar obj = eval(varBodyFrame).document.getElementById(\"race_code\").options;\t\t\t\n\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t{\n\t\t\t\t\tif(obj.options[k].value == \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\tobj.options[k].selected = true;\n\t\t\t\t\t}\n\t\t\t}\n\t\t\t//eval(varBodyFrame).document.getElementById(\"ethnic_group\").disabled = true\n\t\t}\n\n\t\t\t//race_desc,strRaceCd, \n\t\t\n\t\tif(eval(varBodyFrame).document.getElementById(\"ethnic_group\") != null){\n\t\t\t\n\t\t\tif(\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" !=\'\'){\n\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\tvar n = eval(varBodyFrame).document.forms[0].ethnic_group.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\teval(varBodyFrame).document.forms[0].ethnic_group.remove(\"ethnic_group\");\t\n\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\t\t\topt.value=  \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\teval(varBodyFrame).document.getElementById(\"ethnic_group\").add(opt);\n\t\t\t\teval(varBodyFrame).document.getElementById(\"ethnic_group\").options[0].selected = true\n\t\t\t\teval(varBodyFrame).document.getElementById(\"ethnic_group\").disabled = true\n\t\t\t\t\n\t\t\t}else{\n\t\t\t\t\n\t\t\t\tvar n = eval(varBodyFrame).document.forms[0].ethnic_group.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\teval(varBodyFrame).document.forms[0].ethnic_group.remove(\"ethnic_group\");\t\n\t\t\t\tvar temp = \"\";\n\t\t\t\tvar temp1=\"--------\"+getLabel(\'Common.defaultSelect.label\',\'Common\')+\"--------\";\n\t\t\t\tvar opt=eval(varBodyFrame).document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\teval(varBodyFrame).document.forms[0].ethnic_group.add(opt);\t\n\t\t\t\teval(varBodyFrame).document.getElementById(\"ethnic_group\").options[0].selected = true\n\t\t\t}\n\t\t\t\n\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"first_name\") != null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"first_name\").value = \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"\n\t\t\teval(varBodyFrame).document.getElementById(\"first_name\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"second_name\") != null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"second_name\").value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"\n\t\t\teval(varBodyFrame).document.getElementById(\"second_name\").disabled = true\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"third_name\") != null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"third_name\").value = \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"\n\t\t\teval(varBodyFrame).document.getElementById(\"third_name\").disabled = true;\n\t\t}\n\t\t\n\t\tif(eval(varBodyFrame).document.getElementById(\"family_name\") != null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"family_name\").value = \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"\n\t\t\teval(varBodyFrame).document.getElementById(\"family_name\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"name_suffix\") != null)\n\t\t{\n\t\t\tvar obj = eval(varBodyFrame).document.getElementById(\"name_suffix\").options;\n\t\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t\t{\n\t\t\t\tif(obj.options[k].value == \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\")\n\t\t\t\t\tobj.options[k].selected = true;\n\t\t\t}\n\t\t\teval(varBodyFrame).document.getElementById(\"name_suffix\").disabled = true;\n\t\t}\n\n// add for local language names\n\n\n\t\t\t//alert(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\');\n\n\t\t//eval(varBodyFrame).document.getElementById(\"patient_name_local_lang1\").innerHTML = \"<b>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</b>\"\n\t\t//eval(varBodyFrame).document.getElementById(\"patient_name_local_lang\").value = \"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"\n\n\t\t//eval(varBodyFrame).document.getElementById(\"patient_name1\").innerHTML = \"<b>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</b>\";\n\t\teval(varBodyFrame).document.getElementById(\"patient_name\").value =\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\";\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"national_id_no\") != null)\n\t\t{\n\t\t\t\n\t\t\teval(varBodyFrame).document.getElementById(\"national_id_no\").value = \"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\n\t\t\t\n\t\t\teval(varBodyFrame).document.getElementById(\"national_id_no\").disabled = true;\n\t\t\t//eval(varBodyFrame).document.getElementById(\"nationality_desc\").disabled = true;\n\t\t\t//eval(varBodyFrame).document.getElementById(\"nationality_id\").disabled = true;\n\t\t\t\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"myKadBtn\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"myKadBtn\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id1_no\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_no\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id2_no\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id2_no\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id3_no\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id3_no\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id4_no\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id4_no\").disabled = true;\n\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id1_exp_date\").disabled = true;\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt1\").disabled = true;\n\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\")!= null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id2_exp_date\").disabled = true;\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt2\").disabled = true;\n\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\")!= null)\n\t\t{\n\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id3_exp_date\").disabled = true;\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt3\").disabled = true;\n\t\t}\n\t\t\n\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\")!= null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id4_exp_date\").disabled = true;\n\t\t\teval(varBodyFrame).document.getElementById(\"alt_id_exp_dt4\").disabled = true;\n\t\t}\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"other_alt_type\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"other_alt_type\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"other_alt_Id\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"other_alt_Id\").disabled = true;\n\t\t}\n\t\tvar obj = eval(varBodyFrame).document.getElementById(\"sex\").options;\n\t\tfor(var k=0;k<obj.options.length;k++)\n\t\t{\n\t\t\t\tif(obj.options[k].value == \"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\")\n\t\t\t\t\tobj.options[k].selected = true;\n\t\t}\n\t\teval(varBodyFrame).document.getElementById(\"sex\").disabled = true;\n\t\tif(eval(varBodyFrame).document.getElementById(\"date_of_birth\")!=null)\n\t\t{\n\t\t\teval(varBodyFrame).document.getElementById(\"date_of_birth\").value = \"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"\n\t\t\teval(varBodyFrame).document.getElementById(\"date_of_birth\").disabled = true;\n\t\t}\n\t\teval(varBodyFrame).document.getElementById(\"b_age\").value = \"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\teval(varBodyFrame).document.getElementById(\"b_age\").disabled = true;\n\t\teval(varBodyFrame).document.getElementById(\"b_months\").value = \"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\teval(varBodyFrame).document.getElementById(\"b_months\").disabled = true;\n\t\teval(varBodyFrame).document.getElementById(\"b_days\").value =\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\teval(varBodyFrame).document.getElementById(\"b_days\").disabled = true;\n\t\tif(eval(varBodyFrame).document.getElementById(\"dob\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"dob\").disabled = true;\n\n\t\tif(eval(varBodyFrame).document.getElementById(\"nationality_desc\")!=null)\n\t\t{\n\t\tvar obj = eval(varBodyFrame).document.getElementById(\"nationality_desc\");\n\t\tobj.value = \"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"\n\t\teval(varBodyFrame).document.getElementById(\"nationality_code1\").value = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\"\n\t\tif(\teval(varBodyFrame).document.getElementById(\"nationality_desc\").value!=\"\")\n\t\t{\n\t\teval(varBodyFrame).document.getElementById(\"nationality_desc\").disabled = true\n\t\teval(varBodyFrame).document.getElementById(\"nationality_id\").disabled = true\n\t\t} \n\t\telse\n\t\t{\n\t\teval(varBodyFrame).document.getElementById(\"nationality_desc\").disabled = false\n\t\teval(varBodyFrame).document.getElementById(\"nationality_id\").disabled = false\n\t\t\n\t\t}\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"birth_place\")!=null)\n\t\t{\n\t\t  eval(varBodyFrame).document.getElementById(\"birth_place\").disabled = true;\n\t\t  eval(varBodyFrame).document.getElementById(\"b_birth\").disabled = true; \n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"place_of_birth\")!=null)\n\t\t{\n\t\tif(eval(varBodyFrame).document.getElementById(\"place_of_birth\").value!=null)\n\t\t\t\t  eval(varBodyFrame).document.getElementById(\"place_of_birth\").disabled = true;\n\t\t}\n\t\tif(eval(varBodyFrame).document.getElementById(\"birth_place\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"birth_place\").disabled = true\n\t\tif(eval(varBodyFrame).document.getElementById(\"place_of_birth\")!=null)\n\t\teval(varBodyFrame).document.getElementById(\"place_of_birth\").disabled = true\n\t\t\t\n\t\tif(eval(varBodyFrame).document.getElementById(\"citizen_yn\")!=null)\n\t\t{\n\t\t/*if(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[0].value!=null)\n\t\t\t\t   eval(varBodyFrame).document.getElementById(\"citizen_yn\")[0].disabled = true;*/\n\t\t\t\t/*if(eval(varBodyFrame).document.getElementById(\"citizen_yn\")[1].value!=null)\n\t\t\t\t\t{\n\t\t\t\t     eval(varBodyFrame).document.getElementById(\"citizen_yn\")[1].disabled = true;\n\t\t\t\t\t //eval(varBodyFrame).document.getElementById(\"eth_gif\").style.visibility = \'hidden\';\n\t\t\t\t\t}*/\n\t\t\t   /*if(eval(varBodyFrame).document.getElementById(\"legal_yn\")[0].value!=null)\n\t\t\t\t   eval(varBodyFrame).document.getElementById(\"legal_yn\")[0].disabled = true;\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"legal_yn\")[1].value!=null)\n\t\t\t\t   eval(varBodyFrame).document.getElementById(\"legal_yn\")[1].disabled = true;\n\t\t\t  if(eval(varBodyFrame).document.getElementById(\"race_code\").value!= \"\")\n\t\t\t\t eval(varBodyFrame).document.getElementById(\"race_code\").disabled = true;\n\t\t\t  else\n\t\t\t\t eval(varBodyFrame).document.getElementById(\"race_code\").disabled = false;*/\n\t\t}\n\t\t//Added on 10-10-2004\n\t\tputPatientName();\n\t}\n</script>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );
	
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
 
		String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");     
		String locale	=	 ((String)session.getAttribute("LOCALE"));
		request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String strBodyFrame = request.getParameter("bodyFrame");
	String strSubmitFrame = request.getParameter("submitFrame");
	String op_call =request.getParameter("op_call");
	String strAlertReqdYn = request.getParameter("alert_reqd_yn");
	String strNameDrvnLogic = request.getParameter("name_dervn_logic");
	String strPatNameAsMultiPart = request.getParameter("pat_name_as_multipart_yn");

	String facilityid=(String)session.getValue("facility_id");
	String AltId1Type = request.getParameter("AltId1Type");
    String AltId2Type = request.getParameter("AltId2Type");
	String AltId3Type = request.getParameter("AltId3Type");
	String AltId4Type = request.getParameter("AltId4Type");
	String AcceptOtherAltId = request.getParameter("AcceptOtherAltId");
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strAlertReqdYn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strNameDrvnLogic));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strPatNameAsMultiPart));
            _bw.write(_wl_block14Bytes, _wl_block14);

	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;

            _bw.write(_wl_block15Bytes, _wl_block15);

	
	patdata.setFacility_id(facilityid);
	String pat_id = request.getParameter("pat_id");			
    String patientIdStatus = patdata.CheckStatus(con,pat_id);			
	
	String In_patient_status =  patdata.CheckInPatient(con,pat_id,facilityid);
	String alternateIdStatus = patdata.CheckAlternateId(con,pat_id,localeName);
	

            _bw.write(_wl_block1Bytes, _wl_block1);


            _bw.write(_wl_block1Bytes, _wl_block1);

		String	 	strNamePrefix			= "";
		String	 	strFirstName			= "";
		String	 	strSecondName		= "";
		String		strThirdName			= "";
		String	 	strFamilyName			= "";
		String 	strNameSuffix			= "";
		
		String family_name_loc_lang="";
		String third_name_loc_lang="";
		String second_name_loc_lang="";
		String first_name_loc_lang="";
		String name_prefix_loc_lang="";
		String name_suffix_loc_lang="";
		String patient_name_loc_lang="";
		String patient_name="";
	

		String 	strSex					= "";
		String AltId1No				= "";
		String AltId2No				= "";
		String AltId3No				= "";
		String AltId4No				= "";
		String OtherAltIdNo			= "";
		String OtherAltIdType       = "";
		
		String 	strDateOfBirth			= "";
		String 	strNationalityCode    = "";
		String	strNationalityDesc	= "";
		String 	strPrimaryResNo		= "";
		String 	strOtherResNo			= "";
		String 	strYear					= "";
		String 	strMonth					= "";
		String 	strDays					= "";
		String		strCitizenYN			= "";
		String		strLegalYN				= "";

		String		strNatIdNo				= "";
		String		strPatdtlsUnknownYN= "N";


			String	 a_res_addr_line1 = "";
			String a_res_addr_line2 = "";
			String a_res_addr_line3 = "";
			String a_res_addr_line4 = "";
			String a_country_code  = "";
			String a_postal_code    = "";
			
			String a_res_area			= "";
			String a_res_area_code = "";
			String a_res_town2_code = "";
			String a_res_town2_desc = "";
			String a_res_region_code = "";
			String a_res_region_desc = "" ;

			String m_res_addr_line1 = "";
			String m_res_addr_line2 = "";
			String m_res_addr_line3 = "";
			String m_res_addr_line4 = "";
			String m_postal_code    = "";
			String m_country_code  = "";
			String m_res_area_code = "";
			String m_res_area_desc = "";
			String m_res_town2_code = "";
			String m_res_town2_desc = "";
			String m_res_region_code = "";
			String m_res_region_desc = "";

			
			String strEmail			   = "";
			String strRaceCd			   = "";
			String strEthnicGrpCd		   = "";
			String strBirthPldesc	   = "";
			String birth_place_code    ="";
			String place_of_birth      ="";

			String alt_id1_exp_date ="";
			String alt_id2_exp_date ="";
			String alt_id3_exp_date ="";
			String alt_id4_exp_date ="";


			
			String ethnic_desc="";
			String a_country_desc="";
			String m_country_desc="";
			String postal2_desc="";
			String postal_desc="";



            _bw.write(_wl_block16Bytes, _wl_block16);

//String sql = "Select a.patient_id,name_prefix,first_name,second_name,third_name,family_name_prefix,family_name, name_suffix,patient_name,national_id_no,alt_id1_type,nvl(alt_id1_no,'')alt_id1_no,alt_id2_type,nvl(alt_id2_no,'')alt_id2_no,alt_id3_type,nvl(alt_id3_no,'')alt_id3_no,alt_id4_type,nvl(alt_id4_no,'')alt_id4_no,to_char(alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,to_char(alt_id2_exp_date,'dd/mm/yyyy')alt_id2_exp_date,to_char(alt_id3_exp_date,'dd/mm/yyyy')alt_id3_exp_date,to_char(alt_id4_exp_date,'dd/mm/yyyy')alt_id4_exp_date,oth_alt_id_type,nvl(oth_alt_id_no,'')oth_alt_id_no,sex,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, nvl(a.nationality_code,'') nationality_code,c.long_desc nationality_desc,contact1_no primary_resi_no, contact2_no Other_Resi_No,nvl(active_yn,'N') active_yn,nvl(suspend_yn,'N') suspend_yn, nvl(deceased_yn,'N')  deceased_yn  , b.addr1_line1,b.addr1_line2,b.addr1_line3,b.addr1_line4,pref_facility_id,  calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) y,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) m,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) d ,  citizen_yn , legal_yn, national_id_no,a.pat_dtls_unknown_yn,a.RACE_CODE,(select long_desc  from mp_ethnic_group where ethnic_group_code= a.ethnic_grp_code) ethnic_desc,a.ETHNIC_GRP_CODE,a.PLACE_OF_BIRTH,a.birth_place_code,(select long_desc  from MP_BIRTH_PLACE where birth_place_code= a.Birth_place_code) birth_place_desc   from mp_patient a, mp_pat_addresses b,mp_country c  where a.patient_id = '"+pat_id+"'  and a.patient_id = b.patient_id  and a.nationality_code = c.country_code (+)";

String sql = "SELECT  "+
				 "        a.name_prefix,"+
				 "        a.patient_name,"+
				 "        a.first_name,"+
				 "        a.second_name,"+
				 "        a.third_name,"+
				 "        a.family_name_prefix,"+
				 "        a.family_name,"+
				 "        a.name_suffix,"+
				 "        a.national_id_no,"+
				 "        NVL(a.alt_id1_no,'') alt_id1_no,"+
				 "        a.alt_id2_type,"+
				 "        NVL(alt_id2_no,'') alt_id2_no,"+
				 "        a.alt_id3_type,"+
				 "        NVL(a.alt_id3_no,'') alt_id3_no,"+
				 "        a.alt_id4_type,"+
				 "        NVL(a.alt_id4_no,'') alt_id4_no,"+
				 "        TO_CHAR(a.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,"+
				 "        TO_CHAR(a.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,"+
				 "        TO_CHAR(a.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date,"+
				 "        TO_CHAR(a.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date,"+
				 "        a.oth_alt_id_type,"+
				 "        NVL(a.oth_alt_id_no,'') oth_alt_id_no,"+
				 "        a.sex,"+
				 "        TO_CHAR(a.date_of_birth,'dd/mm/yyyy') date_of_birth,"+
				 "        NVL(a.nationality_code,'') nationality_code,"+
				 "        mp_get_desc.MP_COUNTRY(nationality_code,'"+locale+"','3') nationality_desc,"+
				 "        contact1_no primary_resi_no,"+
				 "        contact2_no other_resi_no,"+
				 "        NVL(active_yn,'N') active_yn,"+
				 "        NVL(suspend_yn,'N') suspend_yn,"+
				 "        NVL(deceased_yn,'N') deceased_yn,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),1) y,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),2) m,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),3) d,"+
				 "        a.citizen_yn,"+
				 "        a.legal_yn,"+
				 "        a.pat_dtls_unknown_yn,"+
				 "        a.race_code,"+
				 "        mp_get_desc.MP_ETHNIC_GROUP(a.ethnic_grp_code,'"+locale+"','1') ethnic_desc,"+
				 "        a.ethnic_grp_code,"+
				 "        a.place_of_birth,"+
				 "        a.birth_place_code,"+
				 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"','1') birth_place_desc"+
				 ",a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang, a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang,a.name_prefix_loc_lang"+
				 " FROM   mp_patient a,"+
				 "        mp_pat_addresses b"+
				 " WHERE  a.patient_id = '"+pat_id+"'"+
				 "        AND a.patient_id = b.patient_id";

            _bw.write(_wl_block2Bytes, _wl_block2);

		pstmt = con.prepareStatement(sql) ;
		rs      = pstmt.executeQuery() ;

            _bw.write(_wl_block2Bytes, _wl_block2);

	if(rs != null)
	{
		while(rs.next())
		{
			
			strNamePrefix			= rs.getString("name_prefix");
			strFirstName			= rs.getString("first_name");
			strSecondName		= rs.getString("second_name");
			strThirdName			= rs.getString("third_name");
			strFamilyName			= rs.getString("family_name");
			strNameSuffix			= rs.getString("name_suffix");

			patient_name	=checkForNull(rs.getString("patient_name"));
			patient_name_loc_lang		=checkForNull(rs.getString("patient_name_loc_lang"));
			name_prefix_loc_lang		=checkForNull(rs.getString("name_prefix_loc_lang"));
			first_name_loc_lang		=checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang		=checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang		=checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang		=checkForNull(rs.getString("name_suffix_loc_lang"));

			strNatIdNo				= checkForNull(rs.getString("national_id_no"));
			AltId1No					= checkForNull(rs.getString("alt_id1_no"));
			AltId2No					= checkForNull(rs.getString("alt_id2_no"));
			AltId3No					= checkForNull(rs.getString("alt_id3_no"));
			AltId4No					= checkForNull(rs.getString("alt_id4_no"));

			alt_id1_exp_date     = checkForNull(rs.getString("alt_id1_exp_date"));
			alt_id2_exp_date     = checkForNull(rs.getString("alt_id2_exp_date"));
			alt_id3_exp_date     = checkForNull(rs.getString("alt_id3_exp_date"));
			alt_id4_exp_date     = checkForNull(rs.getString("alt_id4_exp_date"));

			if ( !localeName.equals("en") )
			{ 
				if (!alt_id1_exp_date.equals(""))
						alt_id1_exp_date= DateUtils.convertDate(alt_id1_exp_date,"DMY","en",localeName);
				if (!alt_id2_exp_date.equals(""))
						alt_id2_exp_date= DateUtils.convertDate(alt_id2_exp_date,"DMY","en",localeName);
				if (!alt_id3_exp_date.equals(""))
						alt_id3_exp_date= DateUtils.convertDate(alt_id3_exp_date,"DMY","en",localeName);
				if (!alt_id4_exp_date.equals(""))
						alt_id4_exp_date= DateUtils.convertDate(alt_id4_exp_date,"DMY","en",localeName);
			}

		

			OtherAltIdType		= rs.getString("oth_alt_id_type");
			OtherAltIdNo			= checkForNull(rs.getString("oth_alt_id_no"));
			strSex					= rs.getString("sex");
			strDateOfBirth			= rs.getString("date_of_birth");
			
			if (!strDateOfBirth.equals(""))
			{
				if(!localeName.equals("en"))
				{ 	
					strDateOfBirth= DateUtils.convertDate(strDateOfBirth,"DMY","en",localeName);
				}
			}

			strNationalityCode    = rs.getString("nationality_code");
			strNationalityDesc	= checkForNull(rs.getString("nationality_desc"));
			strPrimaryResNo		= rs.getString("primary_resi_no");
			strOtherResNo			= rs.getString("Other_Resi_No");
			strYear					= rs.getString("y");
			strMonth					= rs.getString("m");
			strDays					= rs.getString("d");
			strCitizenYN			= rs.getString("citizen_yn");
			strLegalYN				= rs.getString("legal_yn");	
			strRaceCd				= rs.getString("RACE_CODE");
			strEthnicGrpCd			= rs.getString("ETHNIC_GRP_CODE");
			strBirthPldesc			= rs.getString("BIRTH_PLACE_DESC");
			birth_place_code		= rs.getString("BIRTH_PLACE_CODE");
			place_of_birth			= rs.getString("PLACE_OF_BIRTH");
			ethnic_desc			= rs.getString("ethnic_desc");
			strPatdtlsUnknownYN = rs.getString("pat_dtls_unknown_yn");
		}
	}
	
	if(pstmt != null)pstmt.close();
	if(rs!=null) rs.close();

	
	String strContact = "SELECT a.addr1_line1,"+
								 "        a.addr1_line2,"+
								 "        a.addr1_line3,"+
								 "        a.addr1_line4,"+
								 "        a.postal1_code,"+
								 "        mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"',2) postal_desc,"+
								 "        a.country1_code,"+
								 "        mp_get_desc.MP_COUNTRY(a.country1_code,'"+locale+"','1') country_desc_1,"+
								 "        a.contact1_name,"+
								 "        mp_get_desc.MP_RES_AREA(b.res_area_code,'"+locale+"','1') res_area,"+
								 "        b.res_area_code,"+
								 "        mp_get_desc.MP_RES_TOWN(b.res_town_code,'"+locale+"','1') res_town,"+
								 "        b.res_town_code,"+
								 "        mp_get_desc.MP_REGION(b.region_code,'"+locale+"','1') region,"+
								 "        b.region_code,"+
								 "        a.addr2_line1,"+
								 "        a.addr2_line2,"+
								 "        a.addr2_line3,"+
								 "        a.addr2_line4,"+
								 "        a.postal2_code,"+
								 "        mp_get_desc.MP_POSTAL_CODE(a.postal2_code,'"+locale+"',2) postal2_desc,"+
								 "        a.country2_code,"+
								 "        mp_get_desc.MP_COUNTRY(a.country2_code,'"+locale+"','1') country_desc_2,"+
								 "        a.contact2_name,"+
								 "        mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2,"+
								 "        a.res_area2_code,"+
								 "        mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2,"+
								 "        a.res_town2_code,"+
								 "        mp_get_desc.MP_REGION(a.region2_code,'"+locale+"','1') region2_desc,"+
								 "        a.region2_code,"+
								 "        b.contact1_no,"+
								 "        b.contact2_no,"+
								 "        b.email_id"+
								 " FROM   mp_pat_addresses a,"+
								 "        mp_patient b"+
								 " WHERE  b.patient_id = a.patient_id"+
								 "        AND b.patient_id = '"+pat_id+"'";

	
	pstmt = con.prepareStatement(strContact) ;
	rs      = pstmt.executeQuery() ;
	
	if(rs != null)
	{
		while(rs.next())
		{
			a_res_addr_line1 = rs.getString("addr1_line1");
			a_res_addr_line2 = rs.getString("addr1_line2");
			a_res_addr_line3 = rs.getString("addr1_line3");
			a_res_addr_line4 = rs.getString("addr1_line4");
			a_country_code  = rs.getString("country1_code");
			a_postal_code    = rs.getString("postal1_code");
			postal2_desc    = rs.getString("postal2_desc");
			postal_desc    = rs.getString("postal_desc");
			
			a_res_area_code		= rs.getString("res_area_code");
			a_res_area				= rs.getString("res_area");			
			a_res_town2_code	= rs.getString("res_town_code");
			a_res_town2_desc	= rs.getString("res_town");
			a_res_region_code	= rs.getString("region_code");
			a_res_region_desc	= rs.getString("region");			

			m_res_addr_line1		= rs.getString("addr2_line1");
			m_res_addr_line2		= rs.getString("addr2_line2");
			m_res_addr_line3		= rs.getString("addr2_line3");
			m_res_addr_line4		= rs.getString("addr2_line4");
			m_postal_code			= rs.getString("postal2_code");
			m_country_code		= rs.getString("country2_code");
			m_res_area_code		= rs.getString("res_area2_code");
			m_res_area_desc		= rs.getString("res_area2");
			m_res_town2_code	= rs.getString("res_town2_code");
			m_res_town2_desc	= rs.getString("res_town2");
			m_res_region_code	= rs.getString("region2_code");
			m_res_region_desc	= rs.getString("region2_desc");
			strPrimaryResNo		= rs.getString("CONTACT1_NO");
			strOtherResNo			= rs.getString("CONTACT2_NO");
			strEmail					= rs.getString("EMAIL_ID");	
			a_country_desc		= rs.getString("country_desc_1");	
			m_country_desc		= rs.getString("country_desc_2");	
		}
	}

	
			if(a_res_addr_line1 == null)a_res_addr_line1="";
			if(a_res_addr_line2 == null)a_res_addr_line2="";
			if(a_res_addr_line3 == null)a_res_addr_line3="";
			if(a_res_addr_line4 == null)a_res_addr_line4="";
			if(a_country_code == null)a_country_code="";
			if(a_postal_code == null)a_postal_code="";
			if(postal_desc == null)postal_desc="";
			if(postal2_desc == null)postal2_desc="";
			if(a_res_area_code == null)a_res_area_code="";
			if(a_res_area == null)a_res_area="";
			if(a_res_town2_code == null)a_res_town2_code="";
			if(a_res_town2_desc == null)a_res_town2_desc="";
			if(a_res_region_code == null)a_res_region_code="";
			if(a_res_region_desc == null)a_res_region_desc="";
			if(m_res_addr_line1 == null)m_res_addr_line1="";
			if(m_res_addr_line2 == null)m_res_addr_line2="";
			if(m_res_addr_line3 == null)m_res_addr_line3="";
			if(m_res_addr_line4 == null)m_res_addr_line4="";
			if(m_postal_code == null)m_postal_code="";
			if(m_country_code == null)m_country_code="";
			if(m_res_area_code == null)m_res_area_code="";
			if(m_res_area_desc == null)m_res_area_desc="";
			if(m_res_town2_code == null)m_res_town2_code="";
			if(m_res_town2_desc == null)m_res_town2_desc="";
			if(m_res_region_code == null)m_res_region_code="";
			if(m_res_region_desc == null)m_res_region_desc="";
			if(strPrimaryResNo == null)strPrimaryResNo="";
			if(strOtherResNo == null)strOtherResNo="";
			if(strEmail == null)strEmail="";

			if(a_country_desc == null)a_country_desc="";
			if(m_country_desc == null)m_country_desc="";
			if(strRaceCd == null)strRaceCd="";
			if(strEthnicGrpCd == null)strEthnicGrpCd="";
			if(birth_place_code == null)birth_place_code="";
			if(place_of_birth == null)place_of_birth="";
			if(strBirthPldesc == null)strBirthPldesc="";
			if(ethnic_desc == null)ethnic_desc="";
			if(strEmail == null)strEmail="";
			

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block20Bytes, _wl_block20);


	
	if(patientIdStatus != ""){

			if (patientIdStatus.equals("BLACKLISTED_PATIENT")){

            _bw.write(_wl_block21Bytes, _wl_block21);
			
			}else if (patientIdStatus.equals("SUSPENDED")){

            _bw.write(_wl_block22Bytes, _wl_block22);

			}else if (patientIdStatus.equals("DECEASED")){

            _bw.write(_wl_block23Bytes, _wl_block23);

			}else if (patientIdStatus.equals("INACTIVE")){

            _bw.write(_wl_block24Bytes, _wl_block24);

			}else if ( patientIdStatus.equals("INVALID_PATIENT")){

            _bw.write(_wl_block25Bytes, _wl_block25);
				
			}else if (patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0 ) {
				StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();				

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
						
			}
		}
			if(In_patient_status.equals("CURRENTLY_IN_PATIENT")){
					
            _bw.write(_wl_block29Bytes, _wl_block29);

				}
				
	if(strPatdtlsUnknownYN.equalsIgnoreCase("Y"))
	{

            _bw.write(_wl_block30Bytes, _wl_block30);

	}



//**@Check the AlterNateId Status **//
	//out.println("alert('"+pat_id+"')");
	
	
if(!AltId1No.equals("") && !AltId1Type.equals("")){
            _bw.write(_wl_block1Bytes, _wl_block1);
}
if(!(AltId2No.equals("")))
	if (!(AltId2Type.equals(""))){
            _bw.write(_wl_block1Bytes, _wl_block1);
}
if(!(AltId3No.equals(""))) 
	if (!(AltId3Type.equals(""))){
            _bw.write(_wl_block1Bytes, _wl_block1);
}
if(!(AltId4No.equals("")))
	if(!(AltId4Type.equals(""))){
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id3_exp_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_id4_exp_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(AcceptOtherAltId.equals("Y") && (!(OtherAltIdNo==""))){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(OtherAltIdType));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(OtherAltIdNo));
            _bw.write(_wl_block38Bytes, _wl_block38);

}
   
  if (!alternateIdStatus.equals("")) 
	{
		char val=alternateIdStatus.charAt(0);
		char vall=alternateIdStatus.charAt(1);

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(val));
            _bw.write(_wl_block40Bytes, _wl_block40);

				String mmsg=alternateIdStatus.substring(2,alternateIdStatus.length());
			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mmsg));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(val));
            _bw.write(_wl_block43Bytes, _wl_block43);

				String mmsg1=alternateIdStatus.substring(1,alternateIdStatus.length());
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mmsg1));
            _bw.write(_wl_block45Bytes, _wl_block45);

				String mmsg2=alternateIdStatus.substring(2,alternateIdStatus.length());
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(mmsg2));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(vall));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(AltId1No));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(vall));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(AltId2No));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(vall));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(AltId3No));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(vall));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(AltId4No));
            _bw.write(_wl_block53Bytes, _wl_block53);
	}
   

            _bw.write(_wl_block54Bytes, _wl_block54);

		if(strCitizenYN.equalsIgnoreCase("Y"))
		{

            _bw.write(_wl_block55Bytes, _wl_block55);
				if(strLegalYN.equalsIgnoreCase("Y")){ 
            _bw.write(_wl_block56Bytes, _wl_block56);
				} else if(strLegalYN.equalsIgnoreCase("N")) { 
            _bw.write(_wl_block57Bytes, _wl_block57);
				} 
            _bw.write(_wl_block58Bytes, _wl_block58);

		}
		else
		{

            _bw.write(_wl_block59Bytes, _wl_block59);
			if(strLegalYN.equalsIgnoreCase("Y")) { 
            _bw.write(_wl_block60Bytes, _wl_block60);
			} else if(strLegalYN.equalsIgnoreCase("N")) { 
            _bw.write(_wl_block61Bytes, _wl_block61);
			} 
            _bw.write(_wl_block62Bytes, _wl_block62);

		}

            _bw.write(_wl_block63Bytes, _wl_block63);



            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(a_res_addr_line1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(a_res_addr_line2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(a_res_addr_line3));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(a_res_addr_line4));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(a_res_town2_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(a_res_town2_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(a_res_area_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(a_res_area));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(a_postal_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(postal_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(a_res_region_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(a_res_region_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(a_country_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(a_country_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(m_res_addr_line1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(m_res_addr_line2));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(m_res_addr_line3));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(m_res_addr_line4));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(m_res_town2_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(m_res_town2_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(m_res_area_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(m_res_area_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(m_postal_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(postal2_desc));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(m_res_region_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(m_res_region_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(m_country_code));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(m_country_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(strPrimaryResNo));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strOtherResNo));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strEmail));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(place_of_birth));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(strBirthPldesc));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strNamePrefix));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strRaceCd));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strEthnicGrpCd));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(ethnic_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(strEthnicGrpCd));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(strFirstName==null?"":strFirstName));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strSecondName==null?"":strSecondName));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strThirdName==null?"":strThirdName));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(strFamilyName==null?"":strFamilyName));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strNameSuffix));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(patient_name_loc_lang));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(strNatIdNo));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(strDateOfBirth));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(strYear));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(strMonth));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(strDays));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(strNationalityDesc));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(strNationalityCode));
            _bw.write(_wl_block121Bytes, _wl_block121);

	if(pstmt != null)pstmt.close();
	if(rs!=null) rs.close();
	if(pstmt1 != null)pstmt1.close();
	if(rs1!=null) rs1.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);

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
