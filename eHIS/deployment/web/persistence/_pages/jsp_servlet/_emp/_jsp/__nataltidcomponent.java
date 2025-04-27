package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __nataltidcomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/natAltIDComponent.jsp", 1733231056319L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<Script language=\'javascript\' src=\'../../eMP/js/natAltIdComponent.js\'></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script language=\'javascript\' src=\'../../eMP/js/SmartCard.js\'></Script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\n<Script src=\"../../eMP/js/json02.js\"></Script>\n<Script src=\"../../eMP/js/jquery.min.js\"></Script>\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n    \n   <script>\n\tfunction checklength(Obj)\n\t{\n\t\t\n\t\tvar maxlength = 0;\n\t\tvar desc = \"\";\n\t\tif(Obj.name == \'national_id_no\')\n\t\t{\n\t\t  maxlength = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t  desc = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\t}\n\t\tif(Obj.name == \'alt_id1_no\')\n\t\t{\n\t\t  maxlength = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\n\t\t}\n\t\tif(Obj.name == \'alt_id2_no\')\n\t\t{\n\t\t  maxlength = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"\n\t\t}\n\t\tif(Obj.name == \'alt_id3_no\')\n\t\t{\n\t\t  maxlength = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n\t\t}\n\t\tif(Obj.name == \'alt_id4_no\')\n\t\t{\n\t\t  maxlength = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n\t\t}\n\t\tif(Obj.value != \"\")\n\t\t{\n\t\tif ( Obj.value.length == maxlength)\n\t\t\t\treturn true;\n \t\telse\n\t\t{\n\t\t\t\tvar msg = getMessage(\"ALT_ID_CHARS\",\'MP\')\n\t\t\t\tmsg =msg.replace(\'$\',desc)\n\t\t\t\tmsg =msg.replace(\'@\',maxlength)\n\t\t\t\talert(msg)\n\t\t\t\tObj.focus();\n\t\t\t\treturn false;\n\t\t}\n\t  }\n\t}\n\t//below code change done for SRR20056-SCF-12671\n\tfunction altID1Validation(event){\n\t\tvar alt_id1_accept_alphanumeric_yn = document.forms[0].alt_id1_accept_alphanumeric_yn.value;\n\t\tvar strCheck = \'\';\n\t\tif (alt_id1_accept_alphanumeric_yn==\'Y\')\n\t\t{\n\t\t\tstrCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tstrCheck = \'0123456789\';\n\t\t}   \n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\treturn (event.keyCode -= 32);\n\t\treturn true ;\n\t}\n\t</script>\n\t<input type =\'hidden\' name=\'dflt_patient_name\' id=\'dflt_patient_name\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<!--for smart card-->\n\t<input type=\"hidden\" name=\"txtSmartcard_path\" id=\"txtSmartcard_path\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"txtSmartcard_dup\" id=\"txtSmartcard_dup\" value=\"\">\n\t<!--for smart card-->\n\t<!--for Alkhaleej smart card-->\n\t<input type=\"hidden\" name=\"txtSmart_fn_name\" id=\"txtSmart_fn_name\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n     ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t\t\t\n\t\t    ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="        \n  \t<table border=\'0\' cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'left\' tabindex=-1>\n\t<tr>\n\t<td align=\'left\' class=\'label\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t<td nowrap class=\'FIELDS\' >\n\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<input type= \'text\' name=\'patient_id\' id=\'patient_id\' size=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  maxlength=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  onchange=\'ChangeUpperCase(this);\' onblur=\'ChangeUpperCase(this);checkPatient(this)\' onKeyPress=\'return CheckForSpecChars(event)\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" tabIndex=\'1\'>  \t\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  onchange=\'ChangeUpperCase(this);checkforOA()\' onblur=\'if (this.value != \"\") ChangeUpperCase(this); checkPatient(this)\' onKeyPress=\'return CheckForSpecChars(event)\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" tabIndex=\'1\'>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<input type=\'button\' name=\'search\' id=\'search\' value=\'?\' disabled class=\"BUTTON\" onClick=\'patSearch()\' tabIndex=\"-1\" >\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<input type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\"BUTTON\" onClick=\'patSearch()\' tabIndex=\"-1\" >\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<img id=\'patgif\' src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden;\' name=\'patgif\'></img>\t\n\t</td>\n\t<td  colspan=\'2\' class=\'querydata\' id=\'patient_name1\'>\n\t</td>\t \t\t\n\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\'\'>\n \t<input type=\'hidden\' name=\'name_dervn_logic_long\' id=\'name_dervn_logic_long\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n \t<input type=\'hidden\' name=\'name_dervn_logic_oth_lang_long\' id=\'name_dervn_logic_oth_lang_long\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n \t\n\t<input type=\'hidden\' name=\'patient_name_long\' id=\'patient_name_long\' value=\'\'>\n\t<input type=\'hidden\' name=\'patient_name_loc_lang_long\' id=\'patient_name_loc_lang_long\' value=\'\'>\n\t\n</tr>  \n<tr>\n\t  <!--Code for dynamically generating NRIC No Starts here -->\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<td  class= \'label\' align = \'left\' nowrap >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<td  class=\'FIELDS\' nowrap width=30%>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<input type=\'text\' name=\'national_id_no\' id=\'national_id_no\' maxlength=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onKeyPress=\'return ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'  size=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onBlur=\'validateID(this,\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\");checklength(this)\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" tabIndex=\'2\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' size=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\");\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" tabIndex=\'2\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<input type=\'hidden\'  name=\'myKadBtn\' id=\'myKadBtn\' value=\'\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<input type=\'button\' value=\'M\' class= \'button\' name=\'myKadBtn\' id=\'myKadBtn\' onClick=\"ReadDF1_onclick(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\',\'IC\',\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\" tabindex=-1 ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" > \n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden;\' name=\'nat_gif\'></img> \n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<!-- <td colspan=2 class= \'label\' align = \'left\'></td> -->\n\t\t\t<td colspan=2 class= \'label\'><input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' maxlength=\'\' onKeyPress=\'\' size=\'20\' onChange=\"\" value=\"\" ><img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden;\' name=\'nat_gif\'></img></td>\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t<input type=\'hidden\' name=\'alt_id1_desc\' id=\'alt_id1_desc\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t<input type=\'hidden\' name=\'alt_id2_desc\' id=\'alt_id2_desc\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t<input type=\'hidden\' name=\'alt_id3_desc\' id=\'alt_id3_desc\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t<input type=\'hidden\' name=\'alt_id4_desc\' id=\'alt_id4_desc\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t<input type=\'hidden\' name=\'readonly_yn\' id=\'readonly_yn\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023\t-->\n\t\t<input type=\'hidden\' name=\'biometric_authentication_yn\' id=\'biometric_authentication_yn\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'nat_id_accept_alphanumeric_yn\' id=\'nat_id_accept_alphanumeric_yn\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric_yn\' id=\'alt_id1_accept_alphanumeric_yn\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<td  colspan=\'2\' class=\'querydata\' id=\'patient_name_local_lang1\' ></td>\n\t\t<input type=\'hidden\' name=\'patient_name_local_lang\' id=\'patient_name_local_lang\' value=\'\'>\n</tr>\n\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t<tr>\n\t    <td class= \'label\' align = \'left\'  nowrap >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t<td nowrap  class=\'FIELDS\' >\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n</tr>\n<tr>\n\t<!-- Code for dynamically generating Alternate ID2 Starts here cut-->\n    <!-- Code for generated Other Alternate ID Ends here -->\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t<td class= \'label\' align = \'left\' nowrap >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" </td>\n\t\t<td  nowrap  class=\'FIELDS\'>\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t<td nowrap  class=\'FIELDS\'>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\n<tr></tr>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t<td  nowrap  class=\'FIELDS\'>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t   \n\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" \n\t <!-- Code for generated Other Alternate ID Starts here -->\n\n \n</tr>\n <tr>\n ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t<td class=\'label\' nowrap align=\'left\' valign=\'center\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td><td><select onchange=\'enabledFields(this);\' name=\'other_alt_type\' id=\'other_alt_type\' tabIndex=\'12\'>\n\t<option value=\'\'>------------";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="-----------\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t</select></td><td class=label>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td><td  class=\'FIELDS\'><input type =\'text\' name = \'other_alt_Id\' id = \'other_alt_Id\' value=\"\" onKeyPress=\'return SpecialCharRestriction(event)\' size=\'15\' maxlength=\'20\' onBlur=\'validateID(this);\' tabIndex=\'13\' disabled></td></tr>\n <tr><td colspan=\'8\' class=\'white\'></td></tr>\n </table>\t\n<!-- @ Code Added for Title Family Name and Suffix on 4th Feb 2004-->\n\n ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n    \t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="   \n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="   \n   ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n<input type=\'hidden\' name=\'alt_id1_man_non_ctz\' id=\'alt_id1_man_non_ctz\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"><!-- Added By Dharma on jan 17th 2014 for [IN:046495] -->\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null ;
	String sql="";
	String alt_id1_reqd_yn="";
	String alt_id2_reqd_yn="";
	String alt_id3_reqd_yn="";
	String alt_id4_reqd_yn="";
	String alt_id1_type="";
	String alt_id2_type="";
	String alt_id3_type="";
	String alt_id4_type="";
	String alt_id1_length="";
	String alt_id2_length="";
	String alt_id3_length="";
	String alt_id4_length="";
	String nat_id_length="";
	String pat_id_length = "";
	String citizen_yn = "Y";
	String alt_id1_exp_date_accept_yn="";
	String alt_id2_exp_date_accept_yn="";
	String alt_id3_exp_date_accept_yn="";
	String alt_id4_exp_date_accept_yn="";
	String accept_national_id_no_yn="";
	String nat_id_accept_alphanumeric_yn="";
	String alt_id1_accept_alphanumeric_yn = "";
	String alt_id1_exp_warn_yn = "";
	String nat_id_prompt="";
	String alt_id1_no = "";
	String alt_id2_no = "";
	String alt_id3_no = "";
	String alt_id4_no = "";
	String national_id_no = "";
	String alt_id1_exp_date = "";
	String alt_id2_exp_date = "";
	String alt_id3_exp_date = "";
	String alt_id4_exp_date = "";
	String disabledFields = "";
	String alt_id1_desc = "";
	String alt_id2_desc = "";
	String alt_id3_desc = "";
	String alt_id4_desc = "";
	String Accept_oth_alt_id_yn = "";

	String nat_id_chk_len = "";
	String  alt_id1_len_validation_yn = "";
    String  alt_id2_len_validation_yn = "";
	String  alt_id3_len_validation_yn = "";
	String  alt_id4_len_validation_yn = "";

	String defaultncode = "";
	String defaultndesc = "";

	String name_dervn_logic = "";
	String name_dervn_logic_long="";
	String name_dervn_logic_oth_lang_long="";

	String pat_name_as_multipart_yn= "";
	String patient_id = request.getParameter("patient_id");
	String call_function = request.getParameter("call_function");
	if(call_function == null) call_function = "";
	String ca_patient_id = request.getParameter("ca_patient_id");
	if(ca_patient_id==null) ca_patient_id = "";
	String op_call = request.getParameter("op_call");
	if(op_call == null) op_call = "";
	String alert_reqd_yn = request.getParameter("alert_reqd_yn");
	String bodyFrame = request.getParameter("bodyFrame");
	String ext_system_interface_yn="";
	String nat_data_source_id="";
	String dflt_patient_name = "";
	String nat_id_check_digit_id = "";
	String biometric_authentication_yn = "";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
	String nat_id_onKeyPress = "";
	//String appt_date=request.getParameter("i_appt_date");
	String readonly_yn = request.getParameter("readonly_yn")==null?"N":request.getParameter("readonly_yn");
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 


	if(bodyFrame == null)
	{
		bodyFrame = "parent.frames[1]";
	}
	String submitFrame = request.getParameter("submitFrame");
	if(submitFrame == null)
	{
		submitFrame = "parent.frames[2]";
	}
	
	if(alert_reqd_yn == null) alert_reqd_yn = "N";
    if (patient_id==null||patient_id.equals("")||patient_id=="") patient_id="";
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try
	{
		con = ConnectionManager.getConnection(request);
		/*Added By Dharma on jan 17th 2014 for [IN:046495] Start*/
		boolean isAltId1ManNonCtz=eOP.QMSInterface.isSiteSpecific(con,"MP","ALT_ID1_MAN_NON_CTZN");
		/*Added By Dharma on jan 17th 2014 for [IN:046495] End*/

		if(!patient_id.equals(""))
		{
			disabledFields = "disabled";
			
			sql = "select alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,to_char(alt_id1_exp_date,'dd/mm/yyyy')alt_id1_exp_date,to_char(alt_id2_exp_date,'dd/mm/yyyy')alt_id2_exp_date,to_char(alt_id3_exp_date,'dd/mm/yyyy')alt_id3_exp_date,to_char(alt_id4_exp_date,'dd/mm/yyyy')alt_id4_exp_date,national_id_no,citizen_yn from mp_patient where patient_id = '"+patient_id+"'";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if (rs!= null&&rs.next())
			{
			
				alt_id1_no = rs.getString("alt_id1_no");
				alt_id2_no = rs.getString("alt_id2_no");
				alt_id3_no = rs.getString("alt_id3_no");
				alt_id4_no = rs.getString("alt_id4_no");
				national_id_no = rs.getString("national_id_no");
				alt_id1_exp_date = rs.getString("alt_id1_exp_date");
				alt_id2_exp_date = rs.getString("alt_id2_exp_date");
				alt_id3_exp_date = rs.getString("alt_id3_exp_date");
				alt_id4_exp_date = rs.getString("alt_id4_exp_date");
				citizen_yn = rs.getString("citizen_yn");

			}
				if(alt_id1_no==null) alt_id1_no = "";
				if(alt_id2_no==null) alt_id2_no = "";
				if(alt_id3_no==null) alt_id3_no = "";
				if(alt_id4_no==null) alt_id4_no = "";
				if(national_id_no==null) national_id_no = "";
				if(alt_id1_exp_date==null) alt_id1_exp_date = "";
				if(alt_id2_exp_date==null) alt_id2_exp_date = "";
				if(alt_id3_exp_date==null) alt_id3_exp_date = "";
				if(alt_id4_exp_date==null) alt_id4_exp_date = "";
		}
		//for smart card
			pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

			rs = pstmt.executeQuery();	


			if(rs!=null && rs.next())
			{
			Smartcard_path=rs.getString("VALUE_1");
			function_name=rs.getString("VALUE_2");   // alkhaleej smart card

			}		


			if(pstmt!=null)
			pstmt.close();
			if(rs!=null)
			rs.close();
			//for smart card
		
	
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,"+
				 "        NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,"+
				 "        NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,"+
				 "        NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,"+
				 "        alt_id1_type,"+
				 "        alt_id2_type,"+
				 "        alt_id3_type,"+
				 "        alt_id4_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,"+
				 "        NVL(alt_id1_length,0) alt_id1_length,"+
				 "        NVL(alt_id2_length,0) alt_id2_length,"+
				 "        NVL(alt_id3_length,0) alt_id3_length,"+
				 "        NVL(alt_id4_length,0) alt_id4_length,"+
				 "        nat_id_length,"+
				 "        patient_id_length,"+
				 "        alt_id1_exp_date_accept_yn,"+
				 "        alt_id2_exp_date_accept_yn,"+
				 "        alt_id3_exp_date_accept_yn,"+
				 "        alt_id4_exp_date_accept_yn,"+
				 "        accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_alphanumeric_yn,"+
				 "        accept_oth_alt_id_yn,"+
				 "        NVL(nat_id_prompt,'National ID No') nat_id_prompt,"+
				 "        name_dervn_logic,NAME_DERVN_LOGIC_LONG,NAME_DERVN_LOGIC_OTH_LANG_LONG,"+ //NAME_DERVN_LOGIC_LONG added on 19/06/2012
				 "        pat_name_as_multipart_yn,"+
				 "        citizen_nationality_code,"+
				 "        mp_get_desc.MP_COUNTRY(citizen_nationality_code,'"+locale+"',1) citizen_nationality_desc,"+
				 "        alt_id1_len_validation_yn,"+
				 "        alt_id2_len_validation_yn,"+
				 "        alt_id3_len_validation_yn,"+
				 "        alt_id4_len_validation_yn,"+
				 "        nat_id_chk_len,"+
				 "        alt_id1_exp_warn_yn,"+
				 "        ext_system_interface_yn,"+
				 "        nat_data_source_id, "+
				 "        dflt_patient_name, "+
				 "        nat_id_check_digit_id, "+
				  "       biometric_authentication_yn "+
				 
				 " FROM   mp_param_lang_vw"+
				 " WHERE  module_id = 'MP' and language_id='"+localeName+"'";
		
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if (rs!= null)
		{
			while(rs.next())
			{
				alt_id1_reqd_yn				= rs.getString("Alt_Id1_reqd_yn");
				alt_id2_reqd_yn				= rs.getString("Alt_Id2_reqd_yn");
				alt_id3_reqd_yn				= rs.getString("Alt_Id3_reqd_yn");
				alt_id4_reqd_yn				= rs.getString("Alt_Id4_reqd_yn");
				alt_id1_type					= rs.getString("Alt_Id1_type");
				alt_id2_type					= rs.getString("Alt_Id2_type");
				alt_id3_type					= rs.getString("Alt_Id3_type");
				alt_id4_type					= rs.getString("Alt_Id4_type");
				alt_id1_length					= rs.getString("Alt_Id1_length");
				alt_id2_length					= rs.getString("Alt_Id2_length");
				alt_id3_length					= rs.getString("Alt_Id3_length");
				alt_id4_length					= rs.getString("Alt_Id4_length");
				nat_id_length					= rs.getString("nat_id_length");
				pat_id_length					= rs.getString("Patient_Id_Length");
				
				alt_id1_len_validation_yn	= rs.getString("alt_id1_len_validation_yn");
				alt_id1_len_validation_yn	= rs.getString("alt_id1_len_validation_yn");
				alt_id2_len_validation_yn	= rs.getString("alt_id2_len_validation_yn");
				alt_id3_len_validation_yn	= rs.getString("alt_id3_len_validation_yn");
				alt_id4_len_validation_yn	= rs.getString("alt_id4_len_validation_yn");
				nat_id_chk_len					= rs.getString("nat_id_chk_len");

				alt_id1_exp_date_accept_yn	= rs.getString("alt_id1_exp_date_accept_yn");
				alt_id2_exp_date_accept_yn	= rs.getString("alt_id2_exp_date_accept_yn");
				alt_id3_exp_date_accept_yn	= rs.getString("alt_id3_exp_date_accept_yn");
				alt_id4_exp_date_accept_yn	= rs.getString("alt_id4_exp_date_accept_yn");
				accept_national_id_no_yn		= rs.getString("accept_national_id_no_yn");
				nat_id_accept_alphanumeric_yn		= rs.getString("nat_id_accept_alphanumeric_yn");
				alt_id1_accept_alphanumeric_yn 		= rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");
				nat_id_prompt 					= rs.getString("nat_id_prompt");
				alt_id1_desc 						= rs.getString("alt_id1_desc");
				alt_id2_desc 						= rs.getString("alt_id2_desc");
				alt_id3_desc 						= rs.getString("alt_id3_desc");
				alt_id4_desc 						= rs.getString("alt_id4_desc");
				Accept_oth_alt_id_yn 			= rs.getString("Accept_oth_alt_id_yn");

				defaultncode = rs.getString("citizen_nationality_code");
				defaultndesc = rs.getString("citizen_nationality_desc");

				name_dervn_logic         =  rs.getString("name_dervn_logic");
				if(name_dervn_logic == null)
				{
					name_dervn_logic = "";
				}
				
				name_dervn_logic_long = rs.getString("NAME_DERVN_LOGIC_LONG");
				
				if (name_dervn_logic_long == null)
				{
					name_dervn_logic_long="";
				}

				

				name_dervn_logic_oth_lang_long = rs.getString("name_dervn_logic_oth_lang_long");
				
				if (name_dervn_logic_oth_lang_long == null)
				{
					name_dervn_logic_oth_lang_long="";
				}

				

				pat_name_as_multipart_yn = rs.getString("pat_name_as_multipart_yn");
				if(pat_name_as_multipart_yn == null)
				{
					pat_name_as_multipart_yn = "";
				}
			    alt_id1_exp_warn_yn = rs.getString("alt_id1_exp_warn_yn");
				ext_system_interface_yn = rs.getString("ext_system_interface_yn")==null?"N":rs.getString("ext_system_interface_yn");
				nat_data_source_id = rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
				dflt_patient_name = rs.getString("dflt_patient_name")==null?"":rs.getString("dflt_patient_name");
				nat_id_check_digit_id = rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
				biometric_authentication_yn = rs.getString("biometric_authentication_yn")==null?"N":rs.getString("biometric_authentication_yn");//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			}
          if(defaultncode==null)defaultncode="";
		  if(defaultndesc==null)defaultndesc="";
		}

		name_dervn_logic = name_dervn_logic.replace('+','!');
				if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";
				if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";
				if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";
				if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";
				if(alt_id1_type == null) alt_id1_type = "";
				if(alt_id2_type == null) alt_id2_type = "";
				if(alt_id3_type == null) alt_id3_type = "";
				if(alt_id4_type == null) alt_id4_type = "";
				if(alt_id1_length == null) alt_id1_length = "0";
				if(alt_id2_length == null) alt_id2_length = "0";
				if(alt_id3_length == null) alt_id3_length = "0";
				if(alt_id4_length == null) alt_id4_length = "0";
				if(nat_id_length == null) nat_id_length = "0";
				if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";
				if(alt_id2_exp_date_accept_yn == null) alt_id2_exp_date_accept_yn = "N";
				if(alt_id3_exp_date_accept_yn == null) alt_id3_exp_date_accept_yn = "N";
				if(alt_id4_exp_date_accept_yn == null) alt_id4_exp_date_accept_yn = "N";
				if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
				if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";
				if(nat_id_prompt == null) nat_id_prompt = "";
				if(alt_id1_desc == null) alt_id1_desc = "";
				if(alt_id2_desc == null) alt_id2_desc = "";
				if(alt_id3_desc == null) alt_id3_desc = "";
				if(alt_id4_desc == null) alt_id4_desc = "";
				if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N";
	
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alt_id1_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alt_id3_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dflt_patient_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Smartcard_path));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            {java.lang.String __page ="PatIdComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patidsize"), weblogic.utils.StringUtils.valueOf(pat_id_length
                        )},{ weblogic.utils.StringUtils.valueOf("AltId1Type"), weblogic.utils.StringUtils.valueOf(alt_id1_type
                        )},{ weblogic.utils.StringUtils.valueOf("AltId2Type"), weblogic.utils.StringUtils.valueOf(alt_id2_type
                        )},{ weblogic.utils.StringUtils.valueOf("AltId3Type"), weblogic.utils.StringUtils.valueOf(alt_id3_type
                        )},{ weblogic.utils.StringUtils.valueOf("AltId4Type"), weblogic.utils.StringUtils.valueOf(alt_id4_type
                        )},{ weblogic.utils.StringUtils.valueOf("AcceptOtherAltId"), weblogic.utils.StringUtils.valueOf(Accept_oth_alt_id_yn
                        )},{ weblogic.utils.StringUtils.valueOf("AltId1No"), weblogic.utils.StringUtils.valueOf(alt_id1_no
                        )},{ weblogic.utils.StringUtils.valueOf("AltId2No"), weblogic.utils.StringUtils.valueOf(alt_id2_no
                        )},{ weblogic.utils.StringUtils.valueOf("AltId3No"), weblogic.utils.StringUtils.valueOf(alt_id3_no
                        )},{ weblogic.utils.StringUtils.valueOf("AltId4No"), weblogic.utils.StringUtils.valueOf(alt_id4_no
                        )},{ weblogic.utils.StringUtils.valueOf("name_dervn_logic"), weblogic.utils.StringUtils.valueOf(name_dervn_logic
                        )},{ weblogic.utils.StringUtils.valueOf("name_dervn_logic_long"), weblogic.utils.StringUtils.valueOf(name_dervn_logic_long
                        )},{ weblogic.utils.StringUtils.valueOf("name_dervn_logic_oth_lang_long"), weblogic.utils.StringUtils.valueOf(name_dervn_logic_oth_lang_long
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_as_multipart_yn"), weblogic.utils.StringUtils.valueOf(pat_name_as_multipart_yn
                        )},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf(bodyFrame
                        )},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf(submitFrame
                        )},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf(alert_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("defaultncode"), weblogic.utils.StringUtils.valueOf(defaultncode
                        )},{ weblogic.utils.StringUtils.valueOf("defaultndesc"), weblogic.utils.StringUtils.valueOf(defaultndesc
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(op_call.equals("ae_reg_pat")){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
if(!ca_patient_id.equals("")) { 
            _bw.write(_wl_block34Bytes, _wl_block34);
}else if(call_function.equals("OT")) { 
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(name_dervn_logic_long));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(name_dervn_logic_oth_lang_long));
            _bw.write(_wl_block38Bytes, _wl_block38);

		if(accept_national_id_no_yn.equals("Y"))
		{
			/*
			if ( nat_id_check_digit_id.equals("M11") )
				nat_id_onKeyPress = " return CheckForCharsNatID(event);";
			else
				nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";
			*/

			if(nat_id_accept_alphanumeric_yn.equals("Y"))
			{
				nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
			}
			else
			{
				if(nat_id_check_digit_id.equals("M11"))
					nat_id_onKeyPress = "CheckForCharsNatID(event);";
				else
					nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
			}
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nat_id_prompt ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(nat_id_chk_len.equals("Y")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( nat_id_length ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( nat_id_length ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
//added by gomathi.
		if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC") && nat_id_check_digit_id.equals(""))
		{
			if(function_name.equals("07")) { // added by Lakshmanan MOHE-CRF-0164.1
				
            _bw.write(_wl_block54Bytes, _wl_block54);

			} else {
			
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bodyFrame));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(submitFrame));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block59Bytes, _wl_block59);
 }
		}
		
            _bw.write(_wl_block60Bytes, _wl_block60);

		}
		else
		{
	
            _bw.write(_wl_block61Bytes, _wl_block61);

		}
	
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(alt_id1_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alt_id3_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(readonly_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(biometric_authentication_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);

		if(!alt_id1_type.equals(""))
		{
	
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(alt_id1_desc ));
            _bw.write(_wl_block72Bytes, _wl_block72);

		if(alt_id1_len_validation_yn.equals("Y"))
		{
        
		out.println("<input type='text' name='alt_id1_no' id='alt_id1_no' onBlur='enabledFields(this);validateID(this);checklength(this)' maxlength='"+alt_id1_length+"' size='"+alt_id1_length+"' value='"+alt_id1_no+"' onKeyPress='return altID1Validation(event)'  "+disabledFields+" tabIndex='4'>");
		}
		else
		{
		 out.println("<input type='text' name='alt_id1_no' id='alt_id1_no' onBlur='enabledFields(this);validateID(this);' maxlength='"+alt_id1_length+"' size='"+alt_id1_length+"' value='"+alt_id1_no+"' onKeyPress='return altID1Validation(event)' "+disabledFields+" tabIndex='4'>");
		}
		if(alt_id1_reqd_yn.equals("N"))
		{
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_gif' id='alt1_gif' ></img>") ;
		}
		else
		{
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_gif' id='alt1_gif'></img>") ;
		}
		out.println("<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='"+alt_id1_reqd_yn+"'> ");
		// Code for dynamically generated Alternate ID1 Ends here

		// Code for dynamically generating Alternate Id1 Exp Date Starts here
	  if(alt_id1_exp_date_accept_yn.equals("Y"))  
	  {
		out.println("<td class=label width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
		
		if(alt_id1_exp_warn_yn.equals("Y"))
		out.println("<td   class='FIELDS' ><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName);checkExpiry1(this);' value = \""+alt_id1_exp_date+"\" "+disabledFields+" tabIndex='5' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt1' name='alt_id_exp_dt1' onClick=\"document.forms[0].alt_id1_exp_date.select();return showCalendar('alt_id1_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img> <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_exp_date1' id='alt1_exp_date1'></img></td>");
		else
		 out.println("<td  class='FIELDS'><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName);' value = \""+alt_id1_exp_date+"\" "+disabledFields+" tabIndex='5' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt1' name='alt_id_exp_dt1' onClick=\"document.forms[0].alt_id1_exp_date.select();return showCalendar('alt_id1_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img> <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_exp_date1' id='alt1_exp_date1'></img></td>");
	  }
	  else
			{
			  out.println("<td ></td><td ></td>");	
			}
	 out.println("</td><input type='hidden' name='alt_id1_type' id='alt_id1_type' value=\""+alt_id1_type+"\">");
	 out.println("<input type='hidden' name='alt_date1_reqd_yn' id='alt_date1_reqd_yn' value='N'> ");
		
		/*alt1_exp_date1,alt_id1_reqd_yn and alt1_gif added by dharma on 17 th jan 2014 for [IN:046495] */
	
	}
	
	
	// Code for dynamically generating Alternate Id1 Exp Date Ends here
	
            _bw.write(_wl_block73Bytes, _wl_block73);

		
		if(!alt_id2_type.equals(""))
		{
	
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);

		//below code change done for SRR20056-SCF-12671
      	if(alt_id2_len_validation_yn.equals("Y"))
		{
			out.println("<input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='enabledFields(this);checklength(this);validateID(this);' maxlength='"+alt_id2_length+"' size='"+alt_id2_length+"' value='"+alt_id2_no+"' onKeyPress='return altID234Validations(event)' tabIndex='6' "+disabledFields+">");
		}
		else
		{
			out.println("<input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='enabledFields(this);validateID(this);' maxlength='"+alt_id2_length+"' size='"+alt_id2_length+"' value='"+alt_id2_no+"' onKeyPress='return altID234Validations(event)' tabIndex='6'  "+disabledFields+">");
		}
		out.println("<input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='"+alt_id2_reqd_yn+"'> ");
	 if(alt_id2_reqd_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' name='alt2_gif'></img>") ;
	 else
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' name='alt2_gif'></img>") ;
	
	 // Code for dynamically generated Alternate ID2 Ends here

	 // Code for dynamically generating Alternate Id2 Exp Date Starts here
	 if(alt_id2_exp_date_accept_yn.equals("Y"))  
	 {
		out.println("<td  class='label' width='25%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
		out.println("<td  class='FIELDS'><input type='text' name='alt_id2_exp_date' id='alt_id2_exp_date' maxlength='10' size='8' onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName)' value = \""+alt_id2_exp_date+"\" "+disabledFields+" tabIndex='7' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt2' name='alt_id_exp_dt2' onClick=\"document.forms[0].alt_id2_exp_date.select();return showCalendar('alt_id2_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img></td>");
	 }
	  else
			{
		      out.println("<td ></td><td ></td>");
			}
			

		out.println("</td><input type='hidden' name='alt_id2_type' id='alt_id2_type' value=\""+alt_id2_type+"\">");	
	}
	out.println("</tr><tr>");
// Code for dynamically generating Alternate Id2 Exp Date Ends here
// Code for dynamically generated Alternate ID3 Starts here

	if(!alt_id3_type.equals(""))
		{
			

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( alt_id3_desc ));
            _bw.write(_wl_block76Bytes, _wl_block76);

		//below code change done for SRR20056-SCF-12671
		if(alt_id3_len_validation_yn.equals("Y"))
		{
		out.println("<input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='"+alt_id3_length+"' onBlur='enabledFields(this);validateID(this);checklength(this);' size='"+alt_id3_length+"' value='"+alt_id3_no+"' onKeyPress='return altID234Validations(event)' tabIndex='8' "+disabledFields+">");
		}
		else
			{
			 out.println("<input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='"+alt_id3_length+"' onBlur='enabledFields(this);validateID(this);' size='"+alt_id3_length+"' value='"+alt_id3_no+"' onKeyPress='return altID234Validations(event)' tabIndex='8' "+disabledFields+">");
			}
		out.println("<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='"+alt_id3_reqd_yn+"'> ");
	  if(alt_id3_reqd_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/mandatory.gif' name='alt3_gif' style='visibility:hidden'></img>") ;
	  else
		out.println("<img src='../../eCommon/images/mandatory.gif' name='alt3_gif' style='visibility:hidden'></img>") ;
	  
// Code for dynamically generated Alternate ID3 Starts here

// Code for dynamically generating Alternate Id3 Exp Date Starts here
	  if(alt_id3_exp_date_accept_yn.equals("Y"))  
	  {
		out.println("<td  class='label' width='25%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
		out.println("<td  class='FIELDS'><input type='text' name='alt_id3_exp_date' id='alt_id3_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName)'  value = \""+alt_id3_exp_date+"\" tabIndex='9' "+disabledFields+" disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt3' name='alt_id_exp_dt3' onClick=\"document.forms[0].alt_id3_exp_date.select();return showCalendar('alt_id3_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img></td> ");
	  }
	  else
			{
			  out.println("<td ></td><td ></td>");	
			}
	  
		out.println("</td><input type='hidden' name='alt_id3_type' id='alt_id3_type' value=\""+alt_id3_type+"\">");		
	}
	
	
	// Code for dynamically generating Alternate Id3 Exp Date Ends here

            _bw.write(_wl_block77Bytes, _wl_block77);

		if(!alt_id4_type.equals(""))
		{
			

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( alt_id4_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);

		//below code change done for SRR20056-SCF-12671
		if(alt_id4_len_validation_yn.equals("Y"))
		{
		out.println("<input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='enabledFields(this);validateID(this);checklength(this)' maxlength='"+alt_id4_length+"' size='"+alt_id4_length+"' value='"+alt_id4_no+"' onKeyPress='return altID234Validations(event)' "+disabledFields+" tabIndex='10' >");
		}
		else
		{
		 out.println("<input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='enabledFields(this);validateID(this);' maxlength='"+alt_id4_length+"' size='"+alt_id4_length+"' value='"+alt_id4_no+"' onKeyPress='return altID234Validations(event)' "+disabledFields+" tabIndex='10' >");
		}
		out.println("<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value=\""+alt_id4_reqd_yn+"\"> ");
	  if(alt_id4_reqd_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' name='alt4_gif'></img>") ;
	  else
		out.println("<img src='../../eCommon/images/mandatory.gif' name='alt4_gif' style='visibility:hidden'></img>") ;
      
	  out.println("</td>");

		
	  
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(alt_id4_exp_date_accept_yn.equals("Y")) 
	  {
		out.println("<td  class='label' width='25%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"") ;
		out.println("<td  class='FIELDS'><input type='text' name='alt_id4_exp_date' id='alt_id4_exp_date' maxlength='10' size='8' onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName)' value = \""+alt_id4_exp_date+"\" "+disabledFields+" tabIndex='11' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt4' name='alt_id_exp_dt4' onClick=\"document.forms[0].alt_id4_exp_date.select();return showCalendar('alt_id4_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img>");
	  }
	  else
			{
			  out.println("<td ></td><td ></td>");	
			}
		out.println("</td><input type='hidden' name='alt_id4_type' id='alt_id4_type' value=\""+alt_id4_type+"\">");
		}
	
// Code for dynamically generating Alternate Id1 Exp Date Ends here

            _bw.write(_wl_block80Bytes, _wl_block80);

		if(Accept_oth_alt_id_yn.equals("Y"))
		{
		  

            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

		sql = "SELECT alt_id_type,long_desc FROM MP_ALTERNATE_ID_TYPE_LANG_VW WHERE language_id='"+localeName+"' and alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM  where module_id='MP' UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and EFF_STATUS='E'";
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	    pstmt = con.prepareStatement(sql);
	    rs = pstmt.executeQuery();	
	    if(rs != null)
		{
			while (rs.next())
			{          
			out.println ( "<Option value=\""+rs.getString("alt_id_type")+"\" >"+rs.getString("long_desc")+"</Option>" ) ;
			}
	  }
		
		}

            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            {java.lang.String __page ="PatDemographicDtlsComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf(alert_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("name_dervn_logic"), weblogic.utils.StringUtils.valueOf(name_dervn_logic
                        )},{ weblogic.utils.StringUtils.valueOf("name_dervn_logic_long"), weblogic.utils.StringUtils.valueOf(name_dervn_logic_long
                        )},{ weblogic.utils.StringUtils.valueOf("name_dervn_logic_oth_lang_long"), weblogic.utils.StringUtils.valueOf(name_dervn_logic_oth_lang_long
                        )},{ weblogic.utils.StringUtils.valueOf("pat_name_as_multipart_yn"), weblogic.utils.StringUtils.valueOf(pat_name_as_multipart_yn
                        )},{ weblogic.utils.StringUtils.valueOf("citizen_yn"), weblogic.utils.StringUtils.valueOf(citizen_yn
                        )},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf(bodyFrame
                        )},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf(submitFrame
                        )},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf(op_call
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(isAltId1ManNonCtz));
            _bw.write(_wl_block90Bytes, _wl_block90);

	}
	catch(Exception e) 
	{ 
		out.println(e.toString());
	}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	    if(con!=null) ConnectionManager.returnConnection(con,request);
	}	

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
}
