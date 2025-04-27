package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __patdemographicdtlscomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatDemographicDtlsComponent.jsp", 1741235999008L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eMP/js/natAltIdComponent.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eMP/js/PatientRegistration1.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script>\n\t\tvarBodyFrame = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\t\n\t\tvarSubmitFrame = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\t\n\t\tfunction CheckBirthPlace()\n\t\t{  \n\t\t\tif(document.forms[0].birth_place.value == \"\")\n\t\t\t   document.forms[0].place_of_birth.disabled = false;\n\t\t\telse\n\t\t\t   document.forms[0].place_of_birth.disabled = true;\n\t\t}\n\t\tfunction CheckBirthCode()\n\t\t{  \n\t\t\tif(document.forms[0].place_of_birth.value\t== \"\")\n\t\t\t{\n\t\t\t   document.forms[0].birth_place.disabled\t= false;\n\t\t\t   document.forms[0].b_birth.disabled\t= false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t  document.forms[0].birth_place.disabled = true;\n\t\t\t  document.forms[0].b_birth.disabled = true;\n\t\t\t}\n\t\t}\n\n\t\tfunction putPatientName()\n\t\t{ \n\n\t\t\tvar logic = new String();\n\t\t    logic = document.getElementById(\"name_dervn_logic\").value;\n\t\t\tvar derivedName = \"\";\n\t\t\tderivedName = \'\';\n\t\t\tvar logicElements = new Array();\n\t\t\tlogicElements = logic.split(\'!\');\n\t\t\tvar i = 0;\n\t\t\tfor(i=0;i<logicElements.length;i++)\n\t\t\t{\n\t\t\t\tif(logicElements[i] == \'1N\' && document.getElementById(\"first_name\") != null)\n\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\"first_name\").value != \'\')\n\t\t\t\t\t\tderivedName = derivedName + document.getElementById(\"first_name\").value;\n\t\t\t\t}\n\t\t\t\telse if(logicElements[i] == \'2N\' && document.getElementById(\"second_name\") != null )\n\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\"second_name\").value != \'\')\n\t\t\t\t\t\tderivedName = derivedName + document.getElementById(\"second_name\").value;\n\t\t\t\t}\n\t\t\t\telse if(logicElements[i] == \'3N\' && (eval(varBodyFrame).document.getElementById(\"third_name\")) != null)\n\t\t\t\t{\n\t\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"third_name\").value != \'\')\n\t\t\t\t\t\tderivedName = derivedName + (eval(varBodyFrame).document.getElementById(\"third_name\")).value;\n\t\t\t\t}\n\t\t\t\telse if(logicElements[i] == \'FN\' && document.getElementById(\"family_name\") != null)\n\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\"family_name\").value != \'\')\n\t\t\t\t\t\tderivedName = derivedName + document.getElementById(\"family_name\").value;\n\t\t\t\t}\n\t\t\t\telse if(logicElements[i] == \'PR\' && document.getElementById(\"name_prefix\") != null)\n\t\t\t\t{\n\n\t\t\t\t\tif(document.getElementById(\"name_prefix\").value != \'\')\n\t\t\t\t\t\tderivedName = derivedName + document.getElementById(\"name_prefix\").value;\n\t\t\t\t}\n\t\t\t\telse if(logicElements[i] == \'SF\' && (eval(varBodyFrame).document.getElementById(\"name_suffix\")) != null)\n\t\t\t\t{\n\t\t\t\t\tif((eval(varBodyFrame).document.getElementById(\"name_suffix\")).value != \'\')\n\t\t\t\t\t\tderivedName = derivedName + (eval(varBodyFrame).document.getElementById(\"name_suffix\")).value;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar arLen\t= logicElements[i].length;\n\t\t\t\t\t\tvar tempVal = logicElements[i].substring(1,arLen - 1);\n\t\t\t\t\t\tif(derivedName == \"\")  tempVal=\"\";\n\t\t\t\t\t\tderivedName = derivedName + tempVal;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t// Commented against IN017482 on 21/12/2009 by Muthu Full name captured for a patient is not reflecting in the No shows/Cancelled Bookings�- There is a truncation in the patient name�\n\n\t\t\t/*\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"pat_name_as_multipart_yn\").value == \"Y\")\n\t\t\t{\n\t\t\t\tif ( derivedName.length >= 40 )\n\t\t\t\t\tderivedName = derivedName.substr(0,40);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ( derivedName.length >= 60 )\n\t\t\t\t\tderivedName = derivedName.substr(0,60);\n\t\t\t}\n\n\t\t\t//added by gomathi\n\t\t\tif(eval(varBodyFrame).document.getElementById(\"name_prefix1\") != null)\n\t\t\t{\n\t\t\t\tif(eval(varBodyFrame).document.getElementById(\"name_prefix1\").value == \'\')\n\t\t\t\t{\n\t\t\t\t\tvar s = derivedName.length;\n\t\t\t\t\tvar temp = derivedName.substring(s);\n\t\t\t\t\tvar temp1 = derivedName.substring(0,s);\n\n\t\t\t\t\tvar n = temp1.charCodeAt(0);\n\t\t\t\t\t//if((n>=65 && n<=91)||(n>=97 && n<=123))\n\t\t\t\t\tif((n<48 || n>57)) // Only check for Numerals. Thai Name is allowed to be entered.\n\t\t\t\t\t{\n\t\t\t\t\t\t  derivedName = temp + temp1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\t   derivedName = temp;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t*/\n\t\t\t// End of Comment\n\n\t\t\tvar derievedName1 = derivedName.split(\',\');\n\t\t\tif(derievedName1[1] == \' \')\n\t\t\t{\n\t\t\t\tderivedName = \tderievedName1[0];\n\t\t\t}\n\t\t\tdocument.getElementById(\"patient_name1\").innerHTML = \"<b>\"+derivedName;\n\t\t\tdocument.getElementById(\"patient_name\").value =derivedName;\n\t\t\t\n\t\t\t//Brunei CRF for Long Names starts\n\tif(document.getElementById(\"name_dervn_logic_long\")){\n\t\t\n\t\tvar longNamelogic = new String();\n\t\tlongNamelogic = document.getElementById(\"name_dervn_logic_long\").value;\n\t\tvar pat_name_as_multipart_yn = document.getElementById(\"pat_name_as_multipart_yn\").value;\n\t\tvar dervdName = \'\';\n\t\tvar logicElements = new Array();\n\t\tlogicElements = longNamelogic.split(\'+\');\n\t\ti=0;\n\t\tfor ( i=0;i<logicElements.length;i++)\n\t\t{\n\t\t\t\n\t\t\tif(logicElements[i] == \'1N\' && document.getElementById(\"first_name\") != null)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif ( document.getElementById(\"first_name\").value != \'\' ){\n\t\t\t\t\tdervdName = dervdName + document.getElementById(\"first_name\").value;\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'2N\' && document.getElementById(\"second_name\") != null )\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"second_name\").value != \'\' ){\n\t\t\t\t\tdervdName = dervdName + document.getElementById(\"second_name\").value;\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'3N\' && document.getElementById(\"third_name\") != null)\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"third_name\").value != \'\' ){\n\t\t\t\t\tdervdName = dervdName + document.getElementById(\"third_name\").value;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'FN\' && document.getElementById(\"family_name\") != null)\n\t\t\t{\n\t\t\t\t  if ( document.getElementById(\"family_name\").value != \'\' ){\n\n\t\t\t\t\tdervdName = dervdName + document.getElementById(\"family_name\").value;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'PR\' && document.getElementById(\"name_prefix\") != null)\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"name_prefix\").value != \'\' )\n\t\t\t\t{\n\t\t\t\t\tdervdName = dervdName + document.getElementById(\"name_prefix\").value;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'SF\' && document.getElementById(\"name_suffix\") != null)\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"name_suffix\").value != \'\' ){\n\t\t\t\t\tdervdName = dervdName + document.getElementById(\"name_suffix\").value;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ( logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\' )\n\t\t\t\t{\n\t\t\t\t\tvar arLen = logicElements[i].length;\n\t\t\t\t\tvar tempVal = logicElements[i].substring(1,arLen - 1);\n\t\t\t\t\tif(dervdName == \"\")  tempVal=\"\";\n\n\t\t\t\t\tdervdName = dervdName + tempVal;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tvar derivedName1 = dervdName.split(\',\');\n\t\t\n\t\tif(derivedName1[1] == \' \')\n\t\t{\n\t\t\tdervdName = \tderivedName1[0];\n\t\t}\n\t   document.getElementById(\"patient_name_long\").value = dervdName;\n   }\n\t//Brunei CRF for Long Name ends\n\n\t\t}\n\n\t\tfunction loadEthnicSubGroup()\n\t\t{  \n\t\t\tvar op_call = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\';\n\t\t\tif(op_call == \'reg_pat\' || op_call == \'ae_reg_pat\')\n\t\t\t{\n\t\t\t\t varSubmitFrame = \"parent.parent.frames[2]\"\n\t\t\t\t varBodyFrame\t= \"parent.parent.frames[1].frames[0]\"\n\t\t\t}\n\n\t \t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMP/jsp/natAltIdDOB.jsp\'><input type=\'hidden\' name=\'process_id\' id=\'process_id\' value=\'3\'><input name=\'race_code\' id=\'race_code\' type=\'hidden\' value=\\\"\"+eval(varBodyFrame).document.getElementById(\"race_code\").value + \"\\\"><input type=\'hidden\'  name=\'bodyFrameRef\' id=\'bodyFrameRef\' value=\\\"\"+varBodyFrame+\"\\\"><input type=\'hidden\'  name=\'op_call\' id=\'op_call\' value=\\\"\"+op_call+\"\\\"></form></BODY></HTML>\";\n\n\t\t\t//eval(varSubmitFrame).document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t     \teval(varSubmitFrame).document.write(HTMLVal);\n\t\t\teval(varSubmitFrame).document.form1.submit();\n\t\t}\n\n\t\tfunction disable_Legal_If_Citzen()\n\t\t{  \n\n\t\t\tif(document.getElementById(\"citizen_yn\").checked==true)\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"legal_yn\")[0].checked=true;\n\t\t\t\tdocument.getElementById(\"citizen\").value=\'Y\';\n\t\t\t\tdocument.getElementById(\"citizen_yn\").value=\'Y\';\n\t\t\t\tdocument.getElementById(\"legal_yn\").value=\'Y\';\n\t\t\t\tdocument.getElementById(\"legal_yn\")[0].disabled = true;\n\t\t\t\tdocument.getElementById(\"legal_yn\")[1].disabled = true;\n\t\t\t\tdocument.getElementById(\"nationality_code1\").value = document.getElementById(\"dflt_nationality_code\").value\n\t\t\t\tdocument.getElementById(\"nationality_desc\").value = document.getElementById(\"dflt_nationality_desc\").value;\n\t\t\t/*\n\t\t\t\tif(document.getElementById(\"race_required_yn\")) {\n\t\t\t\t\tif(document.getElementById(\"race_required_yn\").value==\'Y\')\n\t\t\t\t\t\tdocument.getElementById(\"eth_gif\").style.visibility=\'visible\';\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"race_yn\").value=\'Y\';\n\t\t\t*/\n\n\t\t\t\tdocument.getElementById(\"nationality_desc\").value=document.getElementById(\"dflt_nationality_desc\").value;\n\t\t\t\tdocument.getElementById(\"nationality_code1\").value=document.getElementById(\"dflt_nationality_code\").value;\n\n\t\t\t\tdocument.getElementById(\"race_desc\").disabled = false;\n\t\t\t\tdocument.getElementById(\"race_desc_id\").disabled = false;\n\t\t\t\t//document.getElementById(\"race_code\").disabled = false\n\n\t\t\t\tif(document.getElementById(\"default_race_code\").value==\'\')\n\t\t\t\t{\n\t\t\t\t\t//document.getElementById(\"race_code\").options[0].selected = true;\n\t\t\t\t\tdocument.getElementById(\"race_desc\").value = \"\";\n\t\t\t\t\tdocument.getElementById(\"race_code\").value = \"\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"race_code\").value=document.getElementById(\"default_race_code\").value;\n\t\t\t\t\tdocument.getElementById(\"race_desc\").value=document.getElementById(\"default_race_desc\").value;\n\t\t\t\t\tdocument.getElementById(\"ethnic_group\").disabled = false;\n\t\t\t\t\tloadEthnicSubGroup();\n\t\t\t\t}\n\t\t\t\t\n\n\t\t\t /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/\n\t\t\t  if(document.getElementById(\"alt_id1_man_non_ctz\") && document.getElementById(\"alt_id1_man_non_ctz\").value==\"true\"){ \n\t\t\t\t   if(document.getElementById(\"alt1_gif\")){\n\t\t\t\t\t  document.getElementById(\"alt_id1_reqd_yn\").value=\'N\'; \n\t\t\t\t\t  document.getElementById(\"alt1_gif\").style.visibility=\'hidden\';\n\t\t\t\t   }\n\t\t\t\t   if(document.getElementById(\"alt1_exp_date1\")){\n\t\t\t\t\t  document.getElementById(\"alt_date1_reqd_yn\").value=\'N\';\n\t\t\t\t\t  document.getElementById(\"alt1_exp_date1\").style.visibility=\'hidden\';\n\t\t\t\t   } \n\t\t\t  }\t  \n\t\t\t  /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/\n\t\t\t\t\n\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"legal_yn\")[0].checked=true;\n\t\t\t\tdocument.getElementById(\"citizen\").value=\'N\';\n\t\t\t\tdocument.getElementById(\"citizen_yn\").value=\'N\';\n\t\t\t\tdocument.getElementById(\"legal_yn\").value=\'Y\';\n\t\t\t\tdocument.getElementById(\"nationality_desc\").value=\"\";\n\t\t\t\tdocument.getElementById(\"nationality_code1\").value = \"\";\n\t\t\t\tdocument.getElementById(\"legal_yn\")[0].disabled = false;\n\t\t\t\tdocument.getElementById(\"legal_yn\")[1].disabled = false;\n\n\t\t\t\t/*\n\t\t\t\t\tdocument.getElementById(\"eth_gif\").style.visibility=\'hidden\';\n\t\t\t\t\tdocument.getElementById(\"race_yn\").value=\'N\';\n\t\t\t\t*/\n\n\t\t\t\t/*\n\t\t\t\tdocument.getElementById(\"race_code\").disabled = false\n\t\t\t\tdocument.getElementById(\"race_code\").value=\"\";\n\t\t\t\t*/\n\t\t\t\tdocument.getElementById(\"race_desc\").disabled = false;\n\t\t\t\tdocument.getElementById(\"race_desc_id\").disabled = false;\n\t\t\t\tdocument.getElementById(\"race_code\").value=\"\";\n\t\t\t\tdocument.getElementById(\"race_desc\").value=\"\";\n\t\t\t\tdocument.getElementById(\"ethnic_group\").disabled = false;\n\n\t\t\t /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/\n\t\t\t  if(document.getElementById(\"alt_id1_man_non_ctz\") && document.getElementById(\"alt_id1_man_non_ctz\").value==\"true\"){ \n\t\t\t\t   if(document.getElementById(\"alt1_gif\")){\n\t\t\t\t\t   document.getElementById(\"alt_id1_reqd_yn\").value=\'Y\'; \n\t\t\t\t\t   document.getElementById(\"alt1_gif\").style.visibility=\'visible\';\t\n\t\t\t\t   }\n\t\t\t\t   if(document.getElementById(\"alt1_exp_date1\")){\n\t\t\t\t\t  document.getElementById(\"alt_date1_reqd_yn\").value=\'Y\';\n\t\t\t\t\t  document.getElementById(\"alt1_exp_date1\").style.visibility=\'visible\';\t\t\t\n\t\t\t\t   } \n\t\t\t  }\t  \n\t\t\t  /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/\n\n\t\t\t\tloadEthnicSubGroup();\n\t\t\t}\n\t\t}\n\n\t\t\tfunction chkLegal(){\n\t\t\tif(document.getElementById(\"legal_yn\")[0].checked == true){\n\t\t\t\tdocument.getElementById(\"legal_yn\")[0].value = \"Y\"\n\t\t\t\tdocument.getElementById(\"legal\").value = \"Y\"\n\t\t\t}else{\n\t\t\t\tif(document.getElementById(\"legal_yn\")[1].checked == true){\n\t\t\t\t\tdocument.getElementById(\"legal_yn\")[1].value = \"N\"\n\t\t\t\t\tdocument.getElementById(\"legal\").value = \"N\"\n\t\t\t\t}\n\t\t\t  }\n\t\t\t}\n\t\tasync function searchBirthPlace(obj,target)\n        {\n\t\t\tvar retVal =    new String();\n            var argumentArray  = new Array();\n\t\t\tvar dataNameArray  = new Array();\n\t\t\tvar dataValueArray = new Array();\n\t\t\tvar dataTypeArray  = new Array();\n\n            var tit = \"\";\n\t\t\tvar locale= document.forms[0].locale.value;\n\n\t\t\ttit=getLabel(\"Common.birthPlace.label\",\"common\");\n\t\t\tsql=\"Select birth_place_code code,long_desc description from mp_birth_place_lang_vw where language_id = \'\"+localeName+\"\' AND eff_status=\'E\' and upper(birth_place_code) like upper(?) and upper(long_desc) like upper(?)\";\n\n\t\t\targumentArray[0] =sql;\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = DESC_LINK  ;\n\t\t\targumentArray[7] = DESC_CODE ;\n\n\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\n\t\t\tif(retVal != null && retVal != \"\" )\n\t\t\t{\n\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\ttarget.value=arr[1];\n\n\t\t\t\teval(varBodyFrame).document.getElementById(\"Birth_place_code\").value= arr[0];\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttarget.value=\'\';\n\t\t\t}\n\t\t}\n\t\tasync function searchCountry(obj,target)\n        {\n\t\t\tvar retVal =    new String();\n            var argumentArray  = new Array() ;\n\t\t\tvar dataNameArray  = new Array() ;\n\t\t\tvar dataValueArray = new Array() ;\n\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\tvar locale= document.forms[0].locale.value;\n\t\t\tvar tit=\"\";\n            tit=getLabel(\"Common.nationality.label\",\"common\")\n\t\t\tsql=\"Select country_code code,long_desc description from Mp_Country_lang_vw where language_id = \'\"+localeName+\"\' AND eff_status=\'E\' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)\";\n\t\t\targumentArray[0] =sql;\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = DESC_LINK  ;\n\t\t\targumentArray[7] = DESC_CODE ;\n\n\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\n\t\t\tif(retVal != null && retVal != \"\" )\n\t\t\t{\n\n\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\ttarget.value=arr[1];\n\t\t\t\teval(varBodyFrame).document.getElementById(\"nationality_code1\").value= arr[0];\n\t\t\t\t//dftCountryGroup();\n\t\t\t}\n\t\t\telse{\n\t\t\t\ttarget.value=\'\';\n\t\t\t}\n\t\t}\n\n\t/*Commented as not required to fetch\n\tfunction fetchLocalNames(obj)\n\t{\n\t\tvar oth_name = obj.name\n\t    if(oth_name.indexOf(\"oth_lang\")  == -1 )\n\t\t   oth_name = \"document.forms[0].\"+oth_name+\"_oth_lang\"\n\t\tvar oth_lang = document.forms[0].names_in_oth_lang.value;\n\t\tif( obj.value != \"\"  && oth_name !=null )\n\t\t{\n\n\t\t\tvar HTMLVal = new String();\n\t\t\tHTMLVal = \"<HTML><head></head><BODY class=\'message\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMP/jsp/ServerValidation.jsp\'><input type=\'hidden\' name=\'process_id\' id=\'process_id\' value=\'9\'><input type=\'hidden\' name=\'names_in_oth_lang\' id=\'names_in_oth_lang\' value=\'\"+oth_lang+\"\'><input type=\'hidden\' name=\'name_fld\' id=\'name_fld\' value=\'\" + obj.name +\"\'><input type=\'hidden\' name=\'from_nat_id\' id=\'from_nat_id\' value=\'Y\'><input type=\'hidden\' name=\'param_val\' id=\'param_val\' value=\'\" + obj.value +\"\'>\"\n\t\t\tHTMLVal += \"</form></BODY></HTML>\";\n\t\t\t//parent.parent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.parent.messageFrame.document.write(HTMLVal);\n\t\t\tparent.parent.messageFrame.document.form1.submit();\n\t\t}\n\t}*/\n\n\tfunction putLocalLangPatientName(from){  \n\t\n\t\n\n\tvar language_direction= document.getElementById(\"language_direction1\").value;\n\n\tvar logic = new String();\n    //logic = document.getElementById(\"name_drvn_logic\").value;\n\tlogic = document.getElementById(\"name_drvn_logic_oth_lang\").value;\n\tvar pat_name_as_multipart_yn = document.getElementById(\"pat_name_as_multipart_yn\").value;\n    var derievedName = new String();\n    derievedName = \'\';\n    var logicElements = new Array();\n    logicElements = logic.split(\'+\');\n    var i=0;\n\n\t//if(language_direction!=\"R\")\n\t//{\n\tfor(i=0;i<logicElements.length;i++)\n\n\t{\n\t    if ( logicElements[i] == \'1N\' && document.getElementById(\"first_name_oth_lang\")!= null)\n        {\n            if ( document.getElementById(\"first_name_oth_lang\").value != \'\' )\n                derievedName =  derievedName+ document.getElementById(\"first_name_oth_lang\").value  ;\n        }\n        else if ( logicElements[i] == \'2N\' && document.getElementById(\"second_name_oth_lang\") != null )\n        {\n            if ( document.getElementById(\"second_name_oth_lang\").value != \'\' )\n                derievedName =  derievedName+ document.getElementById(\"second_name_oth_lang\").value ;\n        }\n        else if ( logicElements[i] == \'3N\' && document.getElementById(\"third_name_oth_lang\") != null)\n        {\n            if ( document.getElementById(\"third_name_oth_lang\").value != \'\' )\n                derievedName = derievedName+ document.getElementById(\"third_name_oth_lang\").value ;\n        }\n        else if ( logicElements[i] == \'FN\' && document.getElementById(\"family_name_oth_lang\") != null)\n        {\n            if ( document.getElementById(\"family_name_oth_lang\").value != \'\' )\n                derievedName =  derievedName+ document.g";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="etElementById(\"family_name_oth_lang\").value ;\n        }\n        else if ( logicElements[i] == \'PR\' && document.getElementById(\"name_prefix_oth_lang\") != null)\n        {\n            if ( (document.getElementById(\"name_prefix_oth_lang\")) && (document.getElementById(\"name_prefix_oth_lang\").value != \'\') )\n            {\n                var prefix_loc_lang = document.getElementById(\"name_prefix_oth_lang\").value;\n                prefix_loc_lang = prefix_loc_lang.substring(prefix_loc_lang.indexOf(\"$\")+1,prefix_loc_lang.length);\n                derievedName =   derievedName+prefix_loc_lang ;\n            }\n        }\n        else if ( logicElements[i] == \'SF\' && document.getElementById(\"name_suffix_oth_lang\") != null)\n        {\n            if ( document.getElementById(\"name_suffix_oth_lang\").value != \'\' )\n            {\n                var suffix_loc_lang = document.getElementById(\"name_suffix_oth_lang\").value;\n                suffix_loc_lang = suffix_loc_lang.substring(suffix_loc_lang.indexOf(\"$\")+1,suffix_loc_lang.length);\n                derievedName =   derievedName+suffix_loc_lang ;\n            }\n        }\n        else\n        {\n            if ( logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\' )\n            {\n                var arLen = logicElements[i].length;\n                var tempVal = logicElements[i].substring(1,arLen - 1);\n                if(derievedName == \"\")  tempVal=\"\";\n                derievedName = derievedName + tempVal;\n            }\n        }\n\n    }\n/*\t}\n\telse\n\t{\n\t\tfor ( i=logicElements.length-1;i>=0;i--)\n\t\t{\n\t    if ( logicElements[i] == \'1N\' && document.getElementById(\"first_name_oth_lang\")!= null)\n        {\n            if ( document.getElementById(\"first_name_oth_lang\").value != \'\' )\n                derievedName =  derievedName+ document.getElementById(\"first_name_oth_lang\").value  ;\n        }\n        else if ( logicElements[i] == \'2N\' && document.getElementById(\"second_name_oth_lang\") != null )\n        {\n            if ( document.getElementById(\"second_name_oth_lang\").value != \'\' )\n                derievedName =  derievedName+ document.getElementById(\"second_name_oth_lang\").value ;\n        }\n        else if ( logicElements[i] == \'3N\' && document.getElementById(\"third_name_oth_lang\") != null)\n        {\n            if ( document.getElementById(\"third_name_oth_lang\").value != \'\' )\n                derievedName = derievedName+ document.getElementById(\"third_name_oth_lang\").value ;\n        }\n        else if ( logicElements[i] == \'FN\' && document.getElementById(\"family_name_oth_lang\") != null)\n        {\n            if ( document.getElementById(\"family_name_oth_lang\").value != \'\' )\n                derievedName =  derievedName+ document.getElementById(\"family_name_oth_lang\").value ;\n        }\n        else if ( logicElements[i] == \'PR\' && document.getElementById(\"name_prefix_oth_lang\") != null)\n        {\n            if ( (document.getElementById(\"name_prefix_oth_lang\")) && (document.getElementById(\"name_prefix_oth_lang\").value != \'\') )\n            {\n                var prefix_loc_lang = document.getElementById(\"name_prefix_oth_lang\").value;\n                prefix_loc_lang = prefix_loc_lang.substring(prefix_loc_lang.indexOf(\"$\")+1,prefix_loc_lang.length);\n                derievedName =   derievedName+prefix_loc_lang ;\n            }\n        }\n        else if ( logicElements[i] == \'SF\' && document.getElementById(\"name_suffix_oth_lang\") != null)\n        {\n            if ( document.getElementById(\"name_suffix_oth_lang\").value != \'\' )\n            {\n                var suffix_loc_lang = document.getElementById(\"name_suffix_oth_lang\").value;\n                suffix_loc_lang = suffix_loc_lang.substring(suffix_loc_lang.indexOf(\"$\")+1,suffix_loc_lang.length);\n                derievedName =   derievedName+suffix_loc_lang ;\n            }\n        }\n        else\n        {\n            if ( logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\' )\n            {\n                var arLen = logicElements[i].length;\n                var tempVal = logicElements[i].substring(1,arLen - 1);\n                if(derievedName == \"\")  tempVal=\"\";\n                derievedName = derievedName + tempVal;\n            }\n        }\n\n    }\n\n} */\n/*\n\tif (pat_name_as_multipart_yn == \'N\')\n\t{\n\t\tif ( derievedName.length >= 60 )\n\t\t\tderievedName = derievedName.substr(0,60);\n\t}\n\telse\n\t{\n\t\tif ( derievedName.length >= 40 )\n\t\t\tderievedName = derievedName.substr(0,40);\n\t}\n*/\n\t//\t\t\teval(varBodyFrame).document.getElementById(\"patient_name1\").innerHTML = \"<b>\"+derivedName;\n\t//\t\teval(varBodyFrame).document.getElementById(\"patient_name\").value =derivedName;\n\n\tdocument.getElementById(\"patient_name_local_lang1\").innerHTML = derievedName;\n    document.getElementById(\"patient_name_local_lang\").value = derievedName;\n\n\t\tif(document.getElementById(\"name_dervn_logic_oth_lang_long\")){\n\t\tvar localLongNamelogic = new String();\t   \n\t\tlocalLongNamelogic = document.getElementById(\"name_dervn_logic_oth_lang_long\").value;\n\n\t\tvar pat_name_as_multipart_yn = document.getElementById(\"pat_name_as_multipart_yn\").value;\n\t\tvar derivedName = new String();\n\t\tderivedName = \'\';\n\t\tvar logicElements = new Array();\n\t\tlogicElements = localLongNamelogic.split(\'+\');\n\t\tvar i=0;\t\n\t\tfor ( i=0;i<logicElements.length;i++)\n\t\t{\n\t\t\t\t   \n\t\t\tif ( logicElements[i] == \'1N\' && document.getElementById(\"first_name_oth_lang\")!= null)\n\t\t\t{\n\t\t\t\t\n\t\t\t\n\t\t\t\tif ( document.getElementById(\"first_name_oth_lang\").value != \'\' ){\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =  document.getElementById(\"first_name_oth_lang\").value+derivedName ;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName =  derivedName+ document.getElementById(\"first_name_oth_lang\").value  ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'2N\' && document.getElementById(\"second_name_oth_lang\") != null )\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"second_name_oth_lang\").value != \'\' ){\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =  document.getElementById(\"second_name_oth_lang\").value+derivedName ;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName =  derivedName+ document.getElementById(\"second_name_oth_lang\").value ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'3N\' && document.getElementById(\"third_name_oth_lang\") != null)\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"third_name_oth_lang\").value != \'\' ){\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =  document.getElementById(\"third_name_oth_lang\").value+derivedName ;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName = derivedName+ document.getElementById(\"third_name_oth_lang\").value ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'FN\' && document.getElementById(\"family_name_oth_lang\") != null)\n\t\t\t{\n\t\t\t\tif ( document.getElementById(\"family_name_oth_lang\").value != \'\' ){\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =  document.getElementById(\"family_name_oth_lang\").value+derivedName ;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName =  derivedName+ document.getElementById(\"family_name_oth_lang\").value ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'PR\' && document.getElementById(\"name_prefix_oth_lang\") != null)\n\t\t\t{\n\t\t\t\tif ( (document.getElementById(\"name_prefix_oth_lang\")) && (document.getElementById(\"name_prefix_oth_lang\").value != \'\') )\n\t\t\t\t{\n\t\t\t\t\tvar prefix_loc_lang = document.getElementById(\"name_prefix_oth_lang\").value;\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =  prefix_loc_lang +derivedName;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName =   derivedName+prefix_loc_lang ;\n\t\t\t\t\t}\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'SF\' && document.getElementById(\"name_suffix_oth_lang\") != null)\n\t\t\t{\n\t\t\t\t if ( document.getElementById(\"name_suffix_oth_lang\").value != \'\') \n\t\t\t\t{\n\t\t\t\t\tvar suffix_loc_lang = document.getElementById(\"name_suffix_oth_lang\").value;\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =   suffix_loc_lang+derivedName;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName =   derivedName + suffix_loc_lang ;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ( logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\' )\n\t\t\t\t{\n\t\t\t\t\tvar arLen = logicElements[i].length;\n\t\t\t\t\tvar tempVal = logicElements[i].substring(1,arLen - 1);\n\t\t\t\t\tif(derivedName == \"\")  tempVal=\"\";\n\t\t\t\t\tif(language_direction==\'R\'){\n\t\t\t\t\t\tderivedName =  tempVal+derivedName;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tderivedName = derivedName + tempVal;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t\n\t\t}\n\n\t\tif(document.getElementById(\"patient_name_loc_lang_long\"))\n\t\t{\n\t\t\tdocument.getElementById(\"patient_name_loc_lang_long\").value = derivedName;\n\t\t}\t\n\t}\n\t\n} // End of FUNCTION\n\n\n\n</script>\n\n";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\n<!-- @Declare the  Variables used  -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<input type=\'hidden\' name=\'other_era_diff\' id=\'other_era_diff\' value=\"543\"></input>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<input type=\'hidden\' name=\'other_era_diff\' id=\'other_era_diff\' value=\"0\"></input>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n <tr>\n\t<td colspan=1 width=\'100%\'>\n\t\t<input type=\'hidden\' name=\'names_in_oth_lang\' id=\'names_in_oth_lang\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></input>\n\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang\' id=\'name_drvn_logic_oth_lang\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></input>\n\t\t<input type=\'hidden\' name=\'language_direction1\' id=\'language_direction1\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></input>\n\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<!--\n\t\tNames Component included from Change pat details 12/7/2006\n\t\t-->\n\t\t<table border=\'0\' tabindex=-1>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t</table>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<table cellpadding=0 cellspacing=0 border=0 width=\'100%\' tabindex=-1>\n\t <tr><td colspan=\'8\' class=\'white\'></td></tr>\n\t \t<input type=\'hidden\' name=\'op_call\' id=\'op_call\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<tr>\n\t        ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<td class=label width=\'20%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td  class=\'FIELDS\' nowrap width=\'306pt\'>\n\t\t\t<input type=\"text\" name=\"birth_place\" id=\"birth_place\" id = \"dateofbirth\" maxlength=\"15\" size=\"15\"  onblur=\'if(this.value != \"\" ){searchBirthPlace(b_birth,birth_place);}else{document.getElementById(\"place_of_birth\").disabled = false;}\'  value = \'\' tabIndex=\'25\'><input type=\'button\' name=\'b_birth\' id=\'b_birth\' value=\'?\' class=\'button\' onclick=\'searchBirthPlace(this,birth_place)\' >\n\t\t\t<input type=\"text\" name=\"place_of_birth\" id=\"place_of_birth\" maxlength=\"30\" size=\"20\"  onfocus=\'CheckBirthPlace();\' tabIndex=\'26\' onblur=\'makeValidString(this);CheckBirthCode();\' value=\"\">\n\t\t\t</TD>\n\n\t\t\t<td class=LABEL  width=\'240pt\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td   class=\'FIELDS\' >\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td class=label width=\'200pt\'>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td  width=\'31%\'  class=\'FIELDS\' >\n\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t        <select name=\"sex\" id=\"sex\" onchange=\'checkPrefix()\' tabIndex=\'27\'>\n\t\t\t<option value=\'\'>-----";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="-----</option>\n\t\t\t<option value=\'M\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t\t\t<option value=\'F\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t\t\t<option value=\'U\' >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\n\t\t\t<td class=\'label\' colspan=\'1\'  nowrap width=\'240pt\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td><td  class=\'FIELDS\'>\n\t\t\t<select name=\'reln_with_patient\' id=\'reln_with_patient\' tabIndex=\'28\'>\n\t\t\t<option value=\'\'>-----";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  selected>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<script>document.getElementById(\"reln_with_patient\").disabled = true;</script>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t</select>\n\t\t\t<tr>\n\t\t\t<td Class = \'label\'   >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t<td  class=\'FIELDS\'  >\n\t\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\" size=\"3\" tabIndex=\'29\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur=\"dateCheck(this,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\">Y\n            <input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" size=\"2\" tabIndex=\'30\' onKeyPress=\'return(ChkNumberInput(this,event,0))\'                              onblur=\"dateCheck(this,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\')\"> M\n            <input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"2\"  onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'31\' onblur=\"dateCheck(this,\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\" >D\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td colspan=2>\n\t\t\t<input type=\'button\' class=\'button\' name=\'contact_details\' id=\'contact_details\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'  tabIndex=\'32\' onclick=\'Modal_Contact_Details(this);\' id = \'\' style=\'\'>\n\t\t\t<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'\'>\n\t\t\t</td></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<td class=LABEL >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t<td  class=\'FIELDS\'>\n\t\t\t<input type=\"text\" name=\"date_of_birth\" id=\"date_of_birth\"  maxlength=\"10\" size=\"8\" tabIndex=\'32\' onblur=\"makeValidString(this);dateCheck(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\" value = \'\'><img name=\"dob\" id=\"dob\" src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"if (!document.getElementById(\'date_of_birth\').disabled) { document.forms[0].date_of_birth.focus(); return showCalendar(\'date_of_birth\'); }\">\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<tr><td colspan=\'8\' class=\'white\'></td></tr>\n\t\t</table>\n\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\'100%\' tabindex=-1>\n     \t\t<tr>\n\t\t\t<td  class=\"label\" width=\'20%\' >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<td  class=\'FIELDS\'>\n\t\t\t<table cellpadding=\'2\' cellspacing=0 border=0 width=\'100%\' tabindex=-1><tr><td class=oaborder nowrap width=24%>\n\t\t\t<input type=\'radio\' name=\'citizen_yn\' id=\'citizen_yn\' value=\'Y\' tabIndex=\'33\'  onclick=\'disable_Legal_If_Citzen(this)\' checked>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<input type=\'radio\' name=\'citizen_yn\' id=\'citizen_yn\' value=\'N\' onclick=\'disable_Legal_If_Citzen(this)\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td><td class=label>&nbsp;</td>\n\n\t\t\t</table></td>\n\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t<td  class=\'FIELDS\' >\n\t\t\t<table cellpadding=\'2\' cellspacing=0 border=0 width=\'100%\' tabindex=-1><tr><td class=oaborder nowrap WIDTH=\'17%\'><input type=\'radio\' name=\'legal_yn\' id=\'legal_yn\' value=\"Y\" checked onclick=\'chkLegal(this)\' disabled>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="<input type=\'radio\' name=\'legal_yn\' id=\'legal_yn\' value=\"N\"  onclick=\'chkLegal(this)\' tabIndex=\'34\' disabled>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td><td class=label>&nbsp;</td>\n\t\t\t</table></td>\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td><td  class=\'FIELDS\' width=\'306pt\'><input type=\'text\' name=\'nationality_desc\' id=\'nationality_desc\' size=\'20\' tabIndex=\'35\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" onblur=\'if(this.value !=\"\")searchCountry(nationality_id,nationality_desc);\' ><input type=\'button\' name=\'nationality_id\' id=\'nationality_id\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nationality_desc)\' ><input type=\'hidden\' name=\'nationality_code1\' id=\'nationality_code1\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><input type=\'hidden\' name=\'nationality_desc1\' id=\'nationality_desc1\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><img id=\'nat_gif_nat_gif\' src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t</td>\n\n\t\t\t<input type=hidden name=\'dflt_nationality_code\' id=\'dflt_nationality_code\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\n\t\t\t<input type=hidden name=\'dflt_nationality_desc\' id=\'dflt_nationality_desc\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<input type=hidden name=\'nat_gif_yn\' id=\'nat_gif_yn\' value=\'Y\'>\n\t\t\t<input type=hidden name=\'eth_gif_yn\' id=\'eth_gif_yn\' value=\'Y\'>\n\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\n\n\t\t<td class=\"label\"  width=\'240pt\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t<td class=\'FIELDS\'>\n\t\t<input type=\'text\' name=\'race_desc\' id=\'race_desc\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" onblur=\'if(this.value!=\"\"){searchRace(race_code,race_desc,\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\");loadEthnicSubGroup(this);}else{clearfields();}\'  tabindex=\'2\' ><input type=\'button\'    name=\'race_desc_id\' id=\'race_desc_id\' value=\'?\' class=\'button\' onclick=\'searchRace(this,race_desc,\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\")\' tabindex=\'2\'>\n\t\t<input type=\'hidden\' name=\'race_code\' id=\'race_code\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\n\t<!-- \t\t<select name=\"race_code\" id=\"race_code\"  tabIndex=\'36\' onchange=\'loadEthnicSubGroup(this);\' >\n\t\t\t\t<option value=\"\" >-----";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="-----</option> -->\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t<!-- </select> -->\n\n\t\t<input type=\'hidden\' name=\'race_required_yn\' id=\'race_required_yn\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\'eth_gif\' name=\'eth_gif\' style=\'visibility:hidden\'></img>\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<script>document.forms[0].eth_gif.style.visibility = \'visible\';</script>\n\t\t    ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<script>document.forms[0].eth_gif.style.visibility = \'hidden\';</script>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t<td  class=\'FIELDS\'>\n\t<select name=\"pat_cat\" id=\"pat_cat\">\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t<option value=\"*O\" >Others</option>\n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t</select>\n\t\t</td>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td><td class=\'label\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t<tr>\n\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t<td   class=\'FIELDS\'><Select name=\"ethnic_group\" id=\"ethnic_group\" tabIndex=\'37\'>\n            <Option value=\"\">------- ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" -------</option>\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n            </select>\n        \t</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t<input type=\'button\' class=\'button\' style=\'width:150pt\' name=\'contact_details\' id=\'contact_details\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'  onclick=\'Modal_Contact_Details(this);\' id = \'\' tabIndex=\'38\'>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\n\t\t\t<input type=\'hidden\' name=\'Birth_place_code\' id=\'Birth_place_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'citizen\' id=\'citizen\' value=\'Y\'>\n\t\t\t<input type=\'hidden\' name=\'legal\' id=\'legal\' value=\'Y\'>\n\n\t</tr>\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t<tr>\n\t<td class=\"label\"  >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n\t\t\t<td   class=\'FIELDS\'> <input type=\'text\' name=\'pat_cat_desc\' id=\'pat_cat_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchCategory(pat_cat_code,pat_cat_desc);}else{clearfields();}\'   ><input type=\'button\'    name=\'pat_cat_code_id\' id=\'pat_cat_code_id\' value=\'?\' class=\'button\' onclick=\'searchCategory(this,pat_cat_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'pat_cat_code\' id=\'pat_cat_code\' value=\"\">\t</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'fields\'>&nbsp;</td>\n\n\t</tr>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n</table>\n</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'change_address\' id=\'change_address\' value=\'\'>\n<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\'>\n<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\n<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\'>\n\n<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'\' >\n<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'\' >\n<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'\' >\n<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'\' >\n<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\' >\n<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\'\' >\n\n<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\'>\n<input type=\'hidden\' name=\'res_area_desc\' id=\'res_area_desc\' value=\'\'>\n\n<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'\' >\n<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'\' >\n<input type=\'hidden\' name=\'region_desc\' id=\'region_desc\' value=\'\' >\n<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'\' >\n<input type=\'hidden\' name=\'country_desc\' id=\'country_desc\' value=\'\' >\n<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'\'>\n<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\'>\n\n<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\'>\n\n<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\' maxlength=\'30\' value=\'\'>\n<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\' maxlength=\'30\' value=\'\'>\n<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'\'  maxlength=\'30\'>\n<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_res_town_desc\' id=\'mail_res_town_desc\' value=\'\' maxlength=\'6\'>\n\n<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_res_area_desc\' id=\'mail_res_area_desc\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_region_desc\' id=\'mail_region_desc\' value=\'\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'\' maxlength=\'4\'>\n<input type=\'hidden\' name=\'mail_country_desc\' id=\'mail_country_desc\' value=\'\' maxlength=\'4\'>\n<input type=\'hidden\' name=\'m_postal_code_desc\' id=\'m_postal_code_desc\' value=\'\' maxlength=\'4\'>\n<input type=\'hidden\' name=\'r_postal_code_desc\' id=\'r_postal_code_desc\' value=\'\' maxlength=\'4\'>\n<!--Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\'\'>\n<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\'\'>\n<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\'\'>\n<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\'\'>\n<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\'\'>\n<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\'\'>\n<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\'\'>\n<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\'\'>\n<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\'\'>\n<input type=\'hidden\' name=\'alt_postal_desc\' id=\'alt_postal_desc\' value=\'\'>\n<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\'\'>\n<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\'\'>\n<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\'\'>\n<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\'\'>\n<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n<!--End-->\n\n<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'\'>\n<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\'>\n<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\'>\n<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\'>\n<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\'>\n<input type=\'hidden\' name=\'default_race_code\' id=\'default_race_code\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\'hidden\' name=\'default_race_desc\' id=\'default_race_desc\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\'hidden\' name=\'First_Name_Prompt\' id=\'First_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\'hidden\' name=\'Second_Name_Prompt\' id=\'Second_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\'hidden\' name=\'Third_Name_Prompt\' id=\'Third_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\'hidden\' name=\'Family_Name_Prompt\' id=\'Family_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\'hidden\' name=\'Name_Suffix_Prompt\' id=\'Name_Suffix_Prompt\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=\'hidden\' name=\'Name_Prefix_Prompt\' id=\'Name_Prefix_Prompt\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<input type=\'hidden\' name=\'race_yn\' id=\'race_yn\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\'hidden\' name=\'op_call_check\' id=\'op_call_check\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\n<input type=\'hidden\' name=\'max_patient_age\' id=\'max_patient_age\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\n<!-- Added by Ajay Hatwate for ML--MMOH-CRF-1930 -->\n\n<input type=\'hidden\' name=\'isVisitVirtualCons\' id=\'isVisitVirtualCons\' value=\'\'>\n<input type=\'hidden\' name=\'teleCodeHidden\' id=\'teleCodeHidden\' value=\'\'>\n<input type=\'hidden\' name=\'txtNxtOfKin\' id=\'txtNxtOfKin\' value=\'\'>\n<input type=\'hidden\' name=\'isVirtualConsultation\' id=\'isVirtualConsultation\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n<input type=\'hidden\' name=\'patCountryCode\' id=\'patCountryCode\' value=\'\'>\n<input type=\'hidden\' name=\'patTelCode\' id=\'patTelCode\' value=\'\'>\n<!-- End of ML-MMOH-CRF-1930 -->\n\n\n\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );


	public ArrayList getData1(String sql,String[] whereClause,HttpServletRequest request,JspWriter out,Connection con) throws Exception
	{

	   ArrayList arrL_of_HashMap            = new ArrayList() ;
	   PreparedStatement pstmt1             = null ;
	   ResultSet resultSet                  = null ;
	   ResultSetMetaData resultSetMetaData	= null;
	   //ArrayList deBug                    = new ArrayList() ;

		try
		{
			pstmt1	= con.prepareStatement(sql) ;

            if(whereClause != null)
                for(int index=0; index<whereClause.length ;index++ )
                   pstmt1.setString( index+1, whereClause[index]);

		    resultSet = pstmt1.executeQuery() ;
			if(resultSet != null)
			{
				resultSetMetaData   =   resultSet.getMetaData();
				HashMap hmRecord    =  new HashMap();
                while(resultSet.next())
				{

					for(int i=1; i<=resultSetMetaData.getColumnCount(); i++)
					{
						String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
                        if(column_Val==null) column_Val="";
						hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);
                    }
                    arrL_of_HashMap.add(hmRecord);
				}
				hmRecord.clear();
			}
			if(pstmt1!=null) pstmt1.close();
            if(resultSet!=null) resultSet.close();
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			out.println(e.toString());
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		return arrL_of_HashMap;
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con			= null;
    PreparedStatement pstmt	= null;
    ResultSet rs			= null;
	Statement stmt=null;
	ResultSet alcn_rs=null;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

	Properties p			=	(java.util.Properties) session.getValue("jdbc");

	String strBodyFrame		= request.getParameter("bodyFrame");
	String strSubmitFrame	= request.getParameter("submitFrame");
	String op_call			= request.getParameter("op_call");
	String function_id		= request.getParameter("function_id");
	String citizen_yn		= request.getParameter("citizen_yn") == null ? "N" : request.getParameter("citizen_yn");
	String alcn_criteria_mp=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
	String clinic_code_mp=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
	String pract_id_mp=request.getParameter("i_practitioner_id")==null?"":request.getParameter("i_practitioner_id");
	String appt_date_mp=request.getParameter("i_appt_date")==null?"":request.getParameter("i_appt_date");
	String facility_id_mp=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
	if(function_id == null) function_id = "";
	StringBuffer alcn_srl_no_sql=new StringBuffer("");
	String alcn_srl_no="";
	String alcn_sql="";
	String strServerDate = "";

	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601
	Boolean isVirtualConsultation = false;//Added by Ajay H. for ML-MMOH-CRF-1930



	HashMap hash_Map6	= new HashMap();

	if(op_call == null) op_call = "";
	if(op_call.equals("reg_pat") || op_call.equals("ae_reg_pat"))
	  strBodyFrame = "parent.parent.frames[1].frames[0]";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            _bw.write(_wl_block10Bytes, _wl_block10);


	String mp_param_sql = "select a.max_patient_age,accept_national_id_no_yn,ALT_ID1_EXP_DATE_ACCEPT_YN, ALT_ID2_EXP_DATE_ACCEPT_YN, ALT_ID3_EXP_DATE_ACCEPT_YN,ALT_ID4_EXP_DATE_ACCEPT_YN,name_prefix_accept_yn, name_prefix_reqd_yn, name_suffix_reqd_yn,name_suffix_accept_yn,  nvl(name_prefix_prompt,'')name_prefix_prompt, first_name_accept_yn, first_name_reqd_yn, nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt,second_name_accept_yn, second_name_reqd_yn, nvl(second_name_prompt,'')second_name_prompt, third_name_accept_yn, third_name_reqd_yn, nvl(third_name_prompt,'')third_name_prompt, family_name_accept_yn, family_name_reqd_yn,first_name_order, second_name_order, third_name_order,pat_name_as_multipart_yn, family_name_order,nvl(family_name_prompt,'')family_name_prompt, name_dervn_logic,name_dervn_logic_oth_lang,patient_id_length,NVL(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, NVL(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, NVL(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, NVL(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn,  Alt_Id1_type, Alt_Id2_type, Alt_Id3_type,Alt_Id4_type,NVL(Alt_Id1_length,0)Alt_Id1_length,NVL(Alt_Id2_length,0)Alt_Id2_length, NVL(Alt_Id3_length,0) Alt_Id3_length,NVL(Alt_Id4_length,0)Alt_Id4_length,NVL(Alt_Id1_Unique_yn,'N')Alt_Id1_Unique_yn, NVL(Alt_Id2_Unique_yn,'N')Alt_Id2_Unique_yn,  NVL(Alt_Id3_Unique_yn,'N')Alt_Id3_Unique_yn, NVL(Alt_Id4_Unique_yn,'N')Alt_Id4_Unique_yn,NVL(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN,NVL(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, NVL(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, NVL(ALT_ID4_LEN_VALIDATION_YN,'N')ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn,alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn,alt_id4_exp_date_accept_yn, alt_id1_routine_yn,  alt_id1_data_source_id alt_id1_routine,  alt_id2_routine_yn, alt_id2_data_source_id  alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NVL(nat_id_prompt,'National ID No') nat_id_prompt,alt_id1_chk_digit_scheme,alt_id2_chk_digit_scheme,alt_id3_chk_digit_scheme,  alt_id4_chk_digit_scheme,citizen_nationality_code,default_race_code, names_in_oth_lang_yn, (SELECT b.long_desc FROM mp_country_lang_vw b WHERE language_id = '"+locale+"' AND a.citizen_nationality_code=b.country_code)citizen_nationality_desc,RACE_REQUIRED_YN,(select to_char(sysdate,'dd/mm/yyyy') from dual)serverDate  from mp_param_lang_vw a where language_id = '"+locale+"' and module_id='MP'";


	String max_patient_age		= "";

	String accept_national_id_no_yn		= "";
	String nat_id_prompt				= "";
	String alt_id1_type					= "";
	String alt_id2_type					= "";
	String alt_id3_type					= "";
	String alt_id4_type					= "";
	String alt_id1_reqd_yn				= "";
	String alt_id2_reqd_yn				= "";
	String alt_id3_reqd_yn				= "";
	String alt_id4_reqd_yn				= "";
	String alt_id1_exp_date_accept_yn	= "";
	String alt_id2_exp_date_accept_yn	= "";
	String alt_id3_exp_date_accept_yn	= "";
	String alt_id4_exp_date_accept_yn	= "";
	String strNamePrefixAcceptYN		= "";
	String strNamePrefixReqdYN			= "";
	String strNameSuffixAcceptYN		= "";
	String strNameSuffixReqdYN			= "";
	String strNamePrefixPrompt			= "";
	String strFirstNamePrompt			= "";
	String strSecondNamePrompt			= "";
	String strThirdNamePrompt			= "";
	String strFamilyNamePrompt			= "";
	String strNameSuffixPrompt			= "";
	String pat_name_as_multipart_yn		= "";
	String first_name_disp				= "";
	String second_name_disp				= "";
	String third_name_disp				= "";
	String family_name_disp				= "";
	String name_dervn_logic				= "";
	String name_dervn_logic_oth_lang				= "";

	String[] names			= new String[4] ;
	String[] name_prompts	= new String[4] ;

	//Use of the the following two defaulting values has been removed on 30.10.2004

	String citizen_nationality_code = "";
	String citizen_nationality_desc = "";
	String default_race_code		= "";
	String names_in_oth_lang_yn		= "";
	//String race_code				= "";
	//String race_desc				= "";
	String temp						= "";
	String race_required_yn			= "";

	try
	{
		con = ConnectionManager.getConnection(request);

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601
		isVirtualConsultation=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION");//Added by Ajay for ML-MMOH-CRF-1930 US004
		pstmt	= con.prepareStatement(mp_param_sql);
		//out.println("mp_param_sql"+mp_param_sql.toString());
		rs		= pstmt.executeQuery();

		if(rs != null && rs.next())
		{

			accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
			if(accept_national_id_no_yn==null) accept_national_id_no_yn = "N";

			//03-09-2009
			max_patient_age = rs.getString("max_patient_age");
			if(max_patient_age== null) max_patient_age = "";

			nat_id_prompt = rs.getString("nat_id_prompt");
			if(nat_id_prompt== null) nat_id_prompt = "";

			alt_id1_type = rs.getString("alt_id1_type");
			if(alt_id1_type == null) alt_id1_type = "";

			alt_id1_reqd_yn = rs.getString("alt_id1_reqd_yn");
			if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";

			alt_id2_reqd_yn = rs.getString("alt_id2_reqd_yn");
			if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";

			alt_id3_reqd_yn = rs.getString("alt_id3_reqd_yn");
			if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";

			alt_id4_reqd_yn = rs.getString("alt_id4_reqd_yn");
			if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";

			alt_id2_type = rs.getString("alt_id2_type");
			if(alt_id2_type == null) alt_id2_type = "";

			alt_id3_type = rs.getString("alt_id3_type");
			if(alt_id3_type == null) alt_id3_type = "";

			alt_id4_type = rs.getString("alt_id4_type");
			if(alt_id4_type == null) alt_id4_type = "";
			alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn");
			if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";

			alt_id2_exp_date_accept_yn=rs.getString("alt_id2_exp_date_accept_yn");
			if(alt_id2_exp_date_accept_yn== null) alt_id2_exp_date_accept_yn = "N";
			alt_id3_exp_date_accept_yn=rs.getString("alt_id3_exp_date_accept_yn");
			if(alt_id3_exp_date_accept_yn== null) alt_id3_exp_date_accept_yn = "N";

			alt_id4_exp_date_accept_yn=rs.getString("alt_id4_exp_date_accept_yn");
			if(alt_id4_exp_date_accept_yn== null) alt_id4_exp_date_accept_yn = "N";


			strNamePrefixAcceptYN = rs.getString("name_prefix_accept_yn");
			if(strNamePrefixAcceptYN == null) strNamePrefixAcceptYN = "N";
			strNamePrefixReqdYN = rs.getString("name_prefix_reqd_yn");
			if(strNamePrefixReqdYN == null) strNamePrefixReqdYN = "N";
			strNameSuffixAcceptYN = rs.getString("name_suffix_accept_yn");
			if(strNameSuffixAcceptYN == null) strNameSuffixAcceptYN = "N";
			strNameSuffixReqdYN	= rs.getString("name_suffix_reqd_yn");
			if(strNameSuffixReqdYN == null) strNameSuffixReqdYN="N";
			strNamePrefixPrompt = rs.getString("name_prefix_prompt");
			if(strNamePrefixPrompt == null) strNamePrefixPrompt="";
			strFirstNamePrompt = rs.getString("first_name_prompt");
			if(strFirstNamePrompt == null) strFirstNamePrompt="";
			strSecondNamePrompt	= rs.getString("second_name_prompt");
			if(strSecondNamePrompt == null) strSecondNamePrompt="";
			strThirdNamePrompt = rs.getString("third_name_prompt");
			if(strThirdNamePrompt == null) strThirdNamePrompt="";
			strFamilyNamePrompt	= rs.getString("family_name_prompt");
			if(strFamilyNamePrompt == null) strFamilyNamePrompt="";
			strNameSuffixPrompt = rs.getString("name_suffix_prompt");
			if(strNameSuffixPrompt == null) strNameSuffixPrompt	="";
			citizen_nationality_code = checkForNull(rs.getString("citizen_nationality_code"));
		
			if(	citizen_nationality_code == null) citizen_nationality_code="";
			citizen_nationality_desc = checkForNull(rs.getString("citizen_nationality_desc"));
			
			if(	citizen_nationality_desc == null) citizen_nationality_desc="";
			default_race_code = rs.getString("default_race_code");
			if(default_race_code == null) default_race_code="";

			names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn");
			if(names_in_oth_lang_yn == null) names_in_oth_lang_yn="";
			pat_name_as_multipart_yn = rs.getString("pat_name_as_multipart_yn");
			if(pat_name_as_multipart_yn == null) pat_name_as_multipart_yn="N";

			race_required_yn = rs.getString("RACE_REQUIRED_YN")==null?"":rs.getString("RACE_REQUIRED_YN");
			strServerDate = rs.getString("serverDate");

			

			//patidlength = rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
			name_dervn_logic = rs.getString("name_dervn_logic")==null?"":rs.getString("name_dervn_logic");
			name_dervn_logic_oth_lang = rs.getString("name_dervn_logic_oth_lang")==null?"":rs.getString("name_dervn_logic_oth_lang");
			first_name_disp	= "<input type='text' name='first_name' id='first_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);' ><input type='hidden' class='button' name='b_first' id='b_first' value='?' onclick=\"callSearch(first_name,'first_name_oth_lang','firstname')\" >" ;
			second_name_disp = "<input type='text' name='second_name' id='second_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);'><input type='hidden' class='button' name='b_second' id='b_second' value='?' onclick=\"callSearch(second_name,'second_name_oth_lang','secondname')\" >" ;
			third_name_disp	= "<input type='text' name='third_name' id='third_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);' ><input type='hidden' class='button' name='b_third' id='b_third' value='?' onclick=\"callSearch(third_name,'third_name_oth_lang','thirdname')\">" ;

			if (pat_name_as_multipart_yn.equals("N"))
			{
				family_name_disp = "<input type='text' name='family_name' id='family_name' maxlength='40' size='40' value=''  onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >" ;
			}
			else
			{
				family_name_disp = "<input type='text' name='family_name' id='family_name' maxlength='15' size='15' value= '' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);'><input type='hidden' class='button' name='b_family' id='b_family' value='?' onclick=\"callSearch(family_name,'family_name_oth_lang','familyname')\" >" ;
			}

			if ( checkForNull(rs.getString("first_name_accept_yn")).equals("Y") )
			{
				String first_reqd = "" ;

				if(checkForNull(rs.getString("first_name_reqd_yn")).equals("Y"))
				{
					first_reqd  = first_reqd  +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'> ";
				}

				if( checkForNull(rs.getString("first_name_order")).equals("1") )
				{
					names[0]  =first_name_disp  ;
					name_prompts[0] = strFirstNamePrompt+first_reqd ;
				}
				else if(checkForNull(rs.getString("first_name_order")).equals("2"))
				{
					names[1]  =first_name_disp  ;
					name_prompts[1] = strFirstNamePrompt +first_reqd;
				}
				else if(checkForNull(rs.getString("first_name_order")).equals("3"))
				{
					names[2]  =first_name_disp  ;
					name_prompts[2] = strFirstNamePrompt +first_reqd;
				}
				else
				{
					names[3]  =first_name_disp  ;
					name_prompts[3] = strFirstNamePrompt +first_reqd;
				}
			}

			if ( checkForNull(rs.getString("second_name_accept_yn")).equals("Y") )
			{
				String sec_reqd = "" ;

				if(checkForNull(rs.getString("second_name_reqd_yn")).equals("Y"))
				{
					sec_reqd  = sec_reqd  +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'>";
				}

				if( checkForNull(rs.getString("second_name_order")).equals("1") )
				{
					names[0]  =second_name_disp ;
					name_prompts[0] = strSecondNamePrompt+ sec_reqd ;
				}
				else if(checkForNull(rs.getString("second_name_order")).equals("2"))
				{
					names[1]  =second_name_disp ;
					name_prompts[1] = strSecondNamePrompt+sec_reqd ;
				}
				else if(checkForNull(rs.getString("second_name_order")).equals("3"))
				{
					names[2]  =second_name_disp ;
					name_prompts[2] = strSecondNamePrompt + sec_reqd;
				}
				else
				{
					names[3]  =second_name_disp ;
					name_prompts[3] = strSecondNamePrompt+sec_reqd ;
				}
			}


			if ( checkForNull(rs.getString("third_name_accept_yn")).equals("Y") )
			{
				String th_reqd = "" ;
				if(checkForNull(rs.getString("third_name_reqd_yn")).equals("Y"))
				{
					th_reqd  = th_reqd  +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'>";
				}
				if( checkForNull(rs.getString("third_name_order")).equals("1") )
				{
					names[0]  =third_name_disp ;
					name_prompts[0] = strThirdNamePrompt +th_reqd;
				}
				else if(checkForNull(rs.getString("third_name_order")).equals("2"))
				{
					names[1]  =third_name_disp ;
					name_prompts[1] = strThirdNamePrompt+th_reqd ;
				}
				else if(checkForNull(rs.getString("third_name_order")).equals("3"))
				{
					names[2]  =third_name_disp ;
					name_prompts[2] = strThirdNamePrompt +th_reqd;
				}
				else
				{
					names[3]  =third_name_disp ;
					name_prompts[3] = strThirdNamePrompt+th_reqd ;
				}
			}

			if ( checkForNull(rs.getString("family_name_accept_yn")).equals("Y") )
			{
				String fam_reqd = "" ;
				if(checkForNull(rs.getString("family_name_reqd_yn")).equals("Y"))
				{
						fam_reqd   = fam_reqd   +"<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'>";
				}
				if( checkForNull(rs.getString("family_name_order")).equals("1") )
				{
					names[0]  =family_name_disp  ;
					name_prompts[0] = strFamilyNamePrompt +fam_reqd;
				}
				else if(checkForNull(rs.getString("family_name_order")).equals("2"))
				{
					names[1]  =family_name_disp  ;
					name_prompts[1] = strFamilyNamePrompt+fam_reqd ;
				}
				else if(checkForNull(rs.getString("family_name_order")).equals("3"))
				{
					names[2]  =family_name_disp  ;
					name_prompts[2] = strFamilyNamePrompt +fam_reqd;
				}
				else
				{   
					names[3]  =family_name_disp  ;
					name_prompts[3] = strFamilyNamePrompt +fam_reqd ;
				}
			}
		}



		/**** Added for Arabic ****/

		String language_direction="";
		int count=0;

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;

		rs = pstmt.executeQuery() ;


        if ( rs != null && rs.next() )
		 {
		  count = rs.getInt("total");
		 }

		if ( count==1 )
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}


		/**** End of Arabic changes ****/



            _bw.write(_wl_block1Bytes, _wl_block1);

		if (localeName.equals("th"))
		{
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(name_dervn_logic_oth_lang));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);
            {java.lang.String __page ="PatNamesComp.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block18Bytes, _wl_block18);

			// Commenetd as part of PE and moved to mp_param_lang_vw query
			//String strServerDate = "";
			/*String sqlDate="select to_char(sysdate,'dd/mm/yyyy') from dual";
			pstmt = con.prepareStatement(sqlDate);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			 strServerDate =rs.getString(1);
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();*/
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(!function_id.equals("CHECK_IN_ACCMP_PERSON")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
if(function_id.equals("CHECK_IN_ACCMP_PERSON")){
				String reln_with_patient = request.getParameter("lodger_relation_code")== null?"":request.getParameter("lodger_relation_code");
			
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

					String sql ="select relationship_code, short_desc from mp_relationship_lang_vw where language_id = '"+locale+"' AND eff_status = 'E'  order by short_desc ";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						if(checkForNull(rs.getString("relationship_code")).equals(reln_with_patient))
						{
						
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(checkForNull(rs.getString("relationship_code"))));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block36Bytes, _wl_block36);

						}
						else
						{
							
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(checkForNull(rs.getString("relationship_code"))));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
					}
					if(!reln_with_patient.equals("")){
            _bw.write(_wl_block39Bytes, _wl_block39);
}}
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block45Bytes, _wl_block45);

			
			if(function_id.equals("CHECK_IN_ACCMP_PERSON"))
			{
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strBodyFrame));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strSubmitFrame));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strServerDate));
            _bw.write(_wl_block52Bytes, _wl_block52);
if(!function_id.equals("CHECK_IN_ACCMP_PERSON")){
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(citizen_nationality_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(citizen_nationality_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(citizen_nationality_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(citizen_nationality_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(citizen_nationality_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);

				hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(con,default_race_code,p);
			
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(default_race_code));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

			 /*
			String sql_ethnic="select RACE_CODE,LONG_DESC from mp_race_lang_vw where language_id = '"+locale+"' AND EFF_STATUS='E' order by 2";
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			pstmt = con.prepareStatement(sql_ethnic);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
              race_code=rs.getString("RACE_CODE");
			  race_desc=rs.getString("LONG_DESC");

              if(default_race_code.equals(race_code))
				{

				  temp = race_code;
                out.println("<option value=\""+race_code+"\" selected >"+race_desc+"</option>");
				}
				else
				{

                    out.println("<option value=\""+race_code+"\">"+race_desc+"</option>");
				}
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			*/
	
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(race_required_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);


			if(race_required_yn.equals("Y")) 	{ 
            _bw.write(_wl_block75Bytes, _wl_block75);
 } else if(race_required_yn.equals("N")) { 
            _bw.write(_wl_block76Bytes, _wl_block76);
}

		
            _bw.write(_wl_block77Bytes, _wl_block77);
if(op_call!=null && op_call.equals("OA") && !alcn_criteria_mp.equals("")){
            _bw.write(_wl_block78Bytes, _wl_block78);

		alcn_srl_no_sql.append("select srl_no from oa_clinic_schedule where clinic_code='"+clinic_code_mp+"' and trunc(clinic_date)=to_date('"+appt_date_mp+"','DD/MM/YYYY') and facility_id='"+facility_id_mp+"' and nvl(schedule_status,'X')!='B' ");
		if(pract_id_mp.equals("")){
			alcn_srl_no_sql.append(" and practitioner_id is null ");
		}else{
			alcn_srl_no_sql.append(" and practitioner_id = '"+pract_id_mp+"' ");
		}

		try{
			stmt=con.createStatement();
			alcn_rs=stmt.executeQuery(alcn_srl_no_sql.toString());
			alcn_srl_no_sql.setLength(0);
			if(alcn_rs!=null && alcn_rs.next()){
				alcn_srl_no=alcn_rs.getString("srl_no")==null?"":alcn_rs.getString("srl_no");
			}

		//alcn_sql="select stat_grp_desc,stat_grp_id from am_stat_group where stat_grp_id in(select alcn_catg_code from oa_clinic_schedule_dtl where facility_id = '"+facility_id_mp+"' and clinic_code ='"+clinic_code_mp+"' and srl_no="+alcn_srl_no+") order by stat_grp_desc";
		alcn_sql="select stat_grp_desc,stat_grp_id from am_stat_group where stat_grp_id in(select stat_grp_id from AM_STAT_GRP_DETAIL where MEMBER_ID='"+citizen_nationality_code+"')";
		if(alcn_rs!=null) alcn_rs.close();
		alcn_rs=stmt.executeQuery(alcn_sql);
		int resultCount=0;
	
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

			while(alcn_rs!=null && alcn_rs.next()){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(alcn_rs.getString("stat_grp_id")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alcn_rs.getString("stat_grp_desc")));
            _bw.write(_wl_block82Bytes, _wl_block82);

				resultCount++;
			}
		if(resultCount==0){
            _bw.write(_wl_block83Bytes, _wl_block83);
}
		}catch(Exception ex){
			ex.printStackTrace();
		}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(citizen_nationality_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(citizen_nationality_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);


			String sqlethinic = "select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where language_id = '"+locale+"' AND race_code ='"+temp+"' and eff_status='E' order by long_desc ";

								pstmt = con.prepareStatement(sqlethinic);
								rs = pstmt.executeQuery();
								while (rs.next())
									{
											out.println("<option value=\"" + rs.getString("ethnic_group_code") + "\">" + rs.getString("long_desc")+"</option>");
									}

									if (pstmt != null) pstmt.close();
			                        if (rs != null) rs.close();


			
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
/*Below Line Added for this CRF [RUT-CRF-0011]*/
	if(checkForNull(op_call).equals("OA")){


	
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
}/*End*/
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(default_race_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strFirstNamePrompt));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strSecondNamePrompt));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strThirdNamePrompt));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strFamilyNamePrompt));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(strNameSuffixPrompt));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(strNamePrefixPrompt));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(max_patient_age));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(isVirtualConsultation));
            _bw.write(_wl_block109Bytes, _wl_block109);

}
catch(Exception e){
	e.printStackTrace();
}
finally{
	if(con!=null)
      ConnectionManager.returnConnection(con,request);

	hash_Map6.clear();
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relationshipwithpatient.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Allocation.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category.label", java.lang.String .class,"key"));
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
}
