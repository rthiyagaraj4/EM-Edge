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
import java.util.*;
import org.json.simple.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;

public final class __checknationality extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/checkNationality.jsp", 1743681114104L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emp/jsp/HealthCardInterface.jsp", 1711968138173L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Latest Modified Date : 10/1/2005 4:36 PM -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eMP/js/checkNationality.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\nfunction chkForAltID1Length(obj)\n{\n\tvar ald_id_desc = document.forms[0].alt_id_no.name;\n\talt_id1_length=document.forms[0].alt_id1_length.value;\n\tif((obj.value.length > 0) && (obj.value.length !=alt_id1_length))\n\t{\n\t\t msg = getMessage(\"ALT_ID_CHARS\",\"MP\");\n\t\t msg =msg.replace(\'$\',ald_id_desc);\n\t\t msg =msg.replace(\'@\',alt_id1_length);\n\t\t alert(msg);\n\t\t obj.value = \'\';\n\t}\n}\n\n\nfunction CheckSplCharsNatID(Obj){\n\t\tvar nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;\n\t\t\n        var str = Obj.value;\n        var specCharsExist = true;\n\t\tif(nat_id_accept_alphanumeric_yn==\"Y\")\n\t\t\tstrCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-\';\n\t\telse\n\t\t\tstrCheck = \'0123456789X\';\n\t\t//strCheck = \'0123456789X\';\n        for (i=0;i<str.length;i++){\n            if (strCheck.indexOf(str.charAt(i)) == -1) \n\t\t\t{\n\t\t\t\talert(getMessage(\"NAT_ID_SPL_NOT_ALLOWED\",\'MP\'));\n\t\t\t\tObj.value=\'\'; //smarth card\n\t\t\t\tObj.focus();\n\t\t\t\treturn false;  \n\t\t\t}\n        }\n        return specCharsExist;\n         }\n\nfunction checkXInNatID(Nat_Id)\n{\n\tvar ind = -1;\n\tif (!CheckSplCharsNatID(Nat_Id))\n\t{\n\t\treturn false;\n\t}\n\tif ( (document.forms[0].nat_id_check_digit_id.value==\'M11\') && ( (ind = Nat_Id.value.indexOf(\'X\')) != -1) )\n\t{\n\t\tif (ind < 12)           // X can be entered only at 13th position\n\t\t{\n\t\t\tmsg = getMessage(\'INVALID_NAT_ID\',\'MP\');\n\t\t\tmsg = msg.replace(\"#\",document.getElementById(\'nat_prompt_id\').innerHTML);\n\t\t\talert(msg);\n\t\t\t//Nat_Id.select();\n\t\t\tNat_Id.value = \'\';\n\t\t\tNat_Id.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<html>\n\t\t\t\t\t<head>\n\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\ttop.document.title =\'Check ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t\t\t\t\t</script>\n\n\n\n\n\t\t\t\t\t</head>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<html>\n\t\t\t\t\t\t<head>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</title>\n\t\t\t\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></link>\n\t\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\t\tfunction checkAltNo(check)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(check ==\'Y\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\'alt_holder_yn\').checked == true)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tif(checkField(document.getElementById(\'alt_id_no\'),\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"+\' No\'))\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' == \'N\')\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(isNaN(document.getElementById(\'alt_id_no\').value))\n\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_id_no\').focus();\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar chk_dig_mes = getMessage(\"ALT_ID_NO\",\'MP\');\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tchk_dig_mes = chk_dig_mes.replace(\'$\',\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\talert(chk_dig_mes);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\'alt_id_no\').value.length == \t\t\tdocument.getElementById(\'alt_id_no\').maxLength)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\treturn true;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_CHARS\",\'MP\')\n\t\t\t\t\t\t\t\t\t\t\t\t\tmsg =msg.replace(\'$\',\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\n\t\t\t\t\t\t\t\t\t\t\t\t\tmsg =msg.replace(\'@\',document.getElementById(\'alt_id_no\').maxLength)\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(msg)\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_id_no\').focus();\n\t\t\t\t\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t} // END of second IF\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tparent.window.returnValue = \'G\';\n\t\t\t\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t//End of the Main IF\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if ( document.getElementById(\'alt_holder_yn\').checked == true )\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t if ( checkField(document.getElementById(\'alt_id_no\'),\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"+\' No\') )\n\t\t\t\t\t\t\t\t\t\t\treturn true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.window.returnValue = \'G\';\n\t\t\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}  // End of the Function\n\n\t\t\t\t\t\t\t\tfunction submitAll(check,unique_yn)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif (checkAltNo(check) == true)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t//document.alt_form.submit();\n\t\t\t\t\t\t\t\t\t\tvar params = \"?\";\n\t\t\t\t\t\t\t\t\t\tfor(var i=0;i<document.alt_form.elements.length;i++)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tparams = params+document.alt_form.elements[i].name+\"=\"+escape(document.alt_form.elements[i].value)+\"&\"\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tparams=params+\"alt_unique=\"+unique_yn\n\t\t\t\t\t\t\t\t\t\tlocation.href =\"../../eMP/jsp/checkNationality.jsp\"+params\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\tfunction CancelModal()\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.window.returnValue=\'G\';\n\t\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\tfunction checkBoxClicked()  \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(document.getElementById(\'alt_holder_yn\').checked == true)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_id_no\').readOnly = false;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_holder_yn\').checked = true;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_id_no\').focus();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_holder_yn\').checked = false;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_id_no\').readOnly = true;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'alt_id_no\').value = \'\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tfunction CheckSplCharsAltID(event){\n\t\t\t\t\t\t\t\t\tvar alt_id1_accept_alphanumeric_yn = document.alt_form.alt_id1_accept_alphanumeric_yn.value;\n\t\t\t\t\t\t\t\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t\t\t\t\t\t\t\tkey = String.fromCharCode(whichCode);\n\t\t\t\t\t\t\t\t\tvar specCharsExist = true;\n\t\t\t\t\t\t\t\t\tif(alt_id1_accept_alphanumeric_yn==\"Y\")\n\t\t\t\t\t\t\t\t\t\tstrCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-\';\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\tstrCheck = \'0123456789\';\n\t\t\t\t\t\t\t\t\tif (strCheck.indexOf(key) == -1){\n\t\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\t\t\t\t\t\t\t\treturn (event.keyCode -= 32);\n\t\t\t\t\t\t\t\t\treturn true ;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\n\n\t\t\t\t\t\t</head>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t            <html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'></link></head>\n\t\t\t\t\t            <body class=\'MESSAGE\' onKeyDown=\'lockKey()\'>\t\t\t\t\t\t\t\t\n\t\t\t                   <script>\n\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'==\'Y\')\n\t\t\t\t\t\t\t\t\tframeRef = \"parent.f_query_add_mod.frames[2]\";\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tframeRef = \"parent.f_query_add_mod.patient_sub\";\n\t\t\t\t\t\t\t\t\teval(frameRef+\".document.getElementById(\'nat_id_val\').value =\'F\'\");\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tval1 = eval(frameRef+\".getMessage(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'MP\')\");\n\t\t\t\t\t\t\t\tval1 = val1.replace(\'#\',eval(frameRef+\".document.getElementById(\'nat_id_prompt\').value\"));\n\t\t\t\t\t\t\t\teval(frameRef).window.alert(val1);\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tlet natIdElement = frameRef.document.getElementById(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\n\t\t\t\t\t\t\t\t\t\tnatIdElement.value = \"\";\n\t\t\t\t\t\t\t\t\t\tnatIdElement.focus();\n\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t\t</body></html>\n\t\t\t\t\t\t        ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\').value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'Birth_Date\').value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"; //modified for ML-MMOH-SCF-3108 \n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'b_age\').value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'b_months\').value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'b_days\').value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_birth_code\').value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'sex\').value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_birth_desc\').value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' != null){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_birth\').value=\'\';\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_birth_desc\').disabled=false;\tparent.f_query_add_mod.patient_sub.document.getElementById(\'birth_place\').disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'==\"\") {\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_birth\').disabled=false;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tvar msg = getMessage(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'MP\'); msg = msg.replace(\'#\', parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_id_prompt\').value);alert(msg);\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'national_id_no\').value = \"\" ;\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'==\'N\'){\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_no\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_no\').value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\').value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix\').value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'first_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'first_name\').value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'second_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'second_name\').value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'third_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'third_name\').value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name\').value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_prefix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_prefix\').value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix\').value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t/* As of now external interface will not populate local lang data.\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'first_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'first_name_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'second_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'second_name_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'third_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'third_name_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_oth_lang\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'sex\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'sex\').value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\') && \'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'!=\'\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\').value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.gotoNext(parent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\'));\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.disableEnableYMDH(parent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\'));\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_code\').value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_desc\').value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'race_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'race_code\').value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'race_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'race_desc\').value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'relgn_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'relgn_code\').value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'relgn_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'relgn_desc\').value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line1\').value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line2\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line2\').value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line3\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line3\').value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line4\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line4\').value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_town\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_town\').value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_town_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_town_code\').value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_area\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_area\').value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_area_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_area_code\').value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_region\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_region\').value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_region_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_region_code\').value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_postal_code1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_postal_code1\').value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_code\').value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_desc\').value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1\').value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1_desc\').value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_num1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_num1\').value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_exp_dt1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_exp_dt1\').value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_issue1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_issue1\').value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'issue_date1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'issue_date1\').value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.putPatientName(\'\');\n\t\t\t\t\t\t\t\t\t\t\t\t//parent.f_query_add_mod.patient_sub.putLocalLangPatientName(\'\');\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'PAT_DECEASED_NOT_ALLOWED\',\'MP\'));\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'national_id_no\').value=\'\'; \n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_no\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_no\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'first_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'first_name\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'second_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'second_name\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'third_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'third_name\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_prefix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_prefix\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t/* As of now external interface will not populate local lang data.\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_prefix_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'first_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'first_name_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'second_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'second_name_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'third_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'third_name_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_oth_lang\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_prefix\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_name_prefix\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix_oth_lang\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'name_suffix_oth_lang\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'sex\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'sex\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\')){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.gotoNext(parent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\'));\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.disableEnableYMDH(parent.f_query_add_mod.patient_sub.document.getElementById(\'date_of_birth\'));\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'nationality_desc\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'race_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'race_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'race_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'race_desc\').value=\'\';\t\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'religion_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'religion_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'relgn_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'relgn_desc\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line2\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line2\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line3\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line3\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line4\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_addr_line4\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_town\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_town\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_town_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_town_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_area\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_area\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_area_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_area_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_region\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_region\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_region_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_region_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_postal_code1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_postal_code1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_code\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_code\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'r_country_desc\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1_desc\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_id1_desc\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_num1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_num1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'doc_exp_dt1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'doc_exp_dt1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_issue1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'place_of_issue1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'issue_date1\'))\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'issue_date1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.putPatientName(\'\');\n\t\t\t\t\t\t\t\t\t\t\t\t//parent.f_query_add_mod.patient_sub.putLocalLangPatientName(\'\');\n\t\t\t\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t<html>\n\t\t\t\t\t\t\t\t\t\t<head>\n\t\t\t\t\t\t\t\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'></link>\n\t\t\t\t\t\t\t\t\t\t</head>\n\t\t\t\t\t\t\t\t\t\t<body class= \'message\' onKeyDown=\'lockKey()\' >\n\t\t\t\t\t\t\t\t\t\t\t<form name=\'construct_nat\' id=\'construct_nat\' action=\'../../eMP/jsp/ServerValidation.jsp\' method=\'post\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'process_id\' id=\'process_id\' value=\'11\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Site\' id=\'Site\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'def_nat_id\' id=\'def_nat_id\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'nat_routine\' id=\'nat_routine\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'nat_id_name\' id=\'nat_id_name\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t</form>\n\t\t\t\t\t\t\t\t\t\t</body>\n\t\t\t\t\t\t\t\t\t</html>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t//if(parent.f_query_add_mod.patient_sub.document.getElementById(\'patient_group\').value != \'N\' && \'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' != \"N\" && \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" > 0  && \'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'==\'N\')\n\t\t\t\t\t\t\t\t\t//if(parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\').value == \'N\' && \'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'==\'N\')\n\t\t\t\t\t\t\t\t\tif((((parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\') && parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\').value == \'N\')||parent.f_query_add_mod.patient_sub.document.getElementById(\'patient_group\').value != \'N\') && \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'==\'N\')&& \'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'!=\'ChangePatDtls\'){\n\t\t\t\t\t\t\t\t\t\tif(confirm(getMessage(\"CONFIRM_NAT_SERIES\",\'MP\'))) {\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'patient_id\').value = \'\';\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'patient_id\').readOnly = true;\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\'pat_no_gen_yn\').value = \'Y\';\n\t\t\t\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'==\'Y\'){\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.frames[2].document.getElementById(\'txtSmartcard_dup\').value=\"1\";\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'txtSmartcard_dup\').value=\"1\";\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\'))\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\').value=\'Y\';\n\t\t\t\t\t\t\t\t\t\t\tdocument.construct_nat.submit();\n\t\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\'))\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'nat_series_loaded\').value=\'Y\';\n\t\t\t\t\t\t\t\t\t\t\t//added for Sekure\n\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.getElementById(\'txtSmart_fn_name\').value==\'02\'){\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'txtSmartcard_dup\').value=\"1\";\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].process_id.value=11;\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.construct_nat.submit();\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t} else { ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].process_id.value=11;\n\t\t\t\t\t\t\t\t\t\t\tdocument.construct_nat.submit();\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>  ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\t\tif(parent.messageFrame)\n\t\t\t\t\t\t\t\t {\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"\n\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t  }\n\t\t\t\t\t else\n\t\t\t\t\t {\n\t\t\t\t\t\t\t%>\n\t\t\t\t\t\t\t\t<!--Commented below code on 20th Aug 2018 against ML-MMOH-CRF-1177-->\n\t\t\t\t\t\t\t\t<!--<script language=\'javascript\'>\n\t\t\t\t\t\t\t\tvar nric_fn=parent.f_query_add_mod.patient_sub.document.getElementById(\'txtSmart_fn_name\').value;\n\t\t\t\t\t\t\t\tif(nric_fn==\'02\'){\n\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_new_nat_id_no\')){\n\t\t\t\t\t\t\t\t\t\tvar nk_nat_id=parent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_new_nat_id_no\').value;\n\t\t\t\t\t\t\t\t\t\tif(nk_nat_id!=\'\'){\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tif(parseInt(nk_nat_id.substr(0,2)) > parseInt(parent.f_query_add_mod.patient_sub.document.getElementById(\'ServerDate\').value.substr(8,2))){\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\').value=nk_nat_id.substr(4,2)+\"/\"+nk_nat_id.substr(2,2)+\"/19\"+nk_nat_id.substr(0,2);\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\').value=nk_nat_id.substr(4,2)+\"/\"+nk_nat_id.substr(2,2)+\"/20\"+nk_nat_id.substr(0,2);\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\tif(!ChkDate(parent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\'))){\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\').select();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\').focus();\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' == \'Y\'){\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' == \'TRUE\'){\n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' != \'\')\n\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\').value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\';\n\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_birth_date\').value=\'\';\n\t\t\t\t\t\t\t\t\t}else if(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' == \'FALSE\'){\n\t\t\t\t\t\t\t\t\t\tvar msg = getMessage(\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\',\'MP\'); msg = msg.replace(\'#\', parent.f_query_add_mod.patient_sub.document.getElementById(\'nat_id_prompt\').value);alert(msg);\n\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_new_nat_id_no\').value = \"\" ;\n\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_new_nat_id_no\').focus();\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\');\n\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_new_nat_id_no\').value = \"\" ;\n\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'contact1_new_nat_id_no\').focus();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}/*End*/\n\t\t\t\t\t\t\t\tif(parent.messageFrame)\n\t\t\t\t\t\t\t\t {\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"\n\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t<html>\n\t\t\t\t\t\t\t\t<head>\n\t\t\t\t\t\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'></link>\n\t\t\t\t\t\t\t\t</head>\n\t\t\t\t\t\t\t\t<body class=\'MESSAGE\' onKeyDown=\'lockKey()\'>\n\t\t\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'==\'Y\')\n\t\t\t\t\t\t\t\t\t\tframeRef = \"parent.f_query_add_mod.frames[2]\";\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tframeRef = \"parent.f_query_add_mod.patient_sub\";\n\t\t\t\t\t\t\t\t\t\teval(frameRef+\".document.getElementById(\'nat_id_val\').value =\'F\'\");\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tval1 = eval(frameRef+\".getMessage(\'INVALID_NAT_ID\',\'MP\')\");\n\t\t\t\t\t\t\t\t\tval1 = val1.replace(\'#\',eval(frameRef+\".document.getElementById(\'nat_id_prompt\').value\"));\n\t\t\t\t\t\t\t\t\teval(frameRef).window.alert(val1);\n\t\t\t\t\t\t\t\t\tlet natIdElement = frameRef.document.getElementById(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\');\n\t\t\t\t\t\t\t\t\t\tnatIdElement.value = \"\";\n\t\t\t\t\t\t\t\t\t\tnatIdElement.focus();\n\t\t\t\t\t\t\t\t</script>\n\n\n\t\t\t\t\t\t\t\t</body>\n\t\t\t\t\t\t\t</html>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<script>\n\t\t\t\tif (\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'==\'Y\'){\n\t\t\t\t\tparent.f_query_add_mod.frames[2].document.getElementById(\'txtSmartcard_dup\').value=\"1\";\n\t\t\t\t}else{\n\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'txtSmartcard_dup\').value=\"1\";\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\n/*function SpeCharCheck(which) {\n//var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;\n\t\tvar alt_id1_accept_alphanumeric_yn = document.alt_form.alt_id1_accept_alphanumeric_yn.value;\n\t\t\n  fldval = which.value;\n  fldval = fldval.replace(/^\\s+/,\"\"); // strip leading spaces\n if(alt_id1_accept_alphanumeric_yn==\'Y\')\n{\nif (/[^-a-z0-9\\s]/i.test(fldval)) { // only alphanumeric and space allowed\nalert(getMessage(\"NAT_ID_SPL_NOT_ALLOWED\",\'MP\'));\nwhich.value = \"\";\nwhich.focus();\nreturn false;\n}\n\n}\nelse\n{\nif (/[^a-z0-9\\s]/i.test(fldval)) { // only alphanumeric and space allowed\nalert(getMessage(\"NAT_ID_SPL_NOT_ALLOWED\",\'MP\'));\nwhich.value = \"\";\nwhich.focus();\nreturn false;\n}\n}\n}*/\nfunction SpeCharCheck(which) {\n    var alt_id1_accept_alphanumeric_yn = document.alt_form.alt_id1_accept_alphanumeric_yn.value;\n    var fldval = which.value;\n    fldval = fldval.replace(/^\\s+/, \"\"); // strip leading spaces\n    if (alt_id1_accept_alphanumeric_yn == \'Y\') {\n        if (/[^-a-z0-9\\s]/i.test(fldval)) { // only alphanumeric and space allowed\n            alert(getMessage(\"NAT_ID_SPL_NOT_ALLOWED\", \'MP\'));\n            which.value = \"\";\n            which.focus();\n            return false;\n        }\n    } else {\n        if (/[^a-z0-9\\s]/i.test(fldval)) { // only alphanumeric and space allowed\n            alert(getMessage(\"NAT_ID_SPL_NOT_ALLOWED\", \'MP\'));\n            which.value = \"\";\n            which.focus();\n            return false;\n        }\n    }\n}\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    public HashMap HealthCardData(java.sql.Connection con, String curr_ds_id, String scr_item_name, String scr_item_value,javax.servlet.jsp.JspWriter out, String frame_ref)
    {
        java.sql.PreparedStatement stmt = null;
        java.sql.ResultSet rset = null ;
        String sql ="";
        String ret_script = "" ;
        HashMap return_hash =  new HashMap() ;

        try
        {
            if(curr_ds_id != null)
            {
                sql = "Select Dsrc_Col_Name from MP_DATASOURCE_MAPPING_VW where Datasource_id = ? and Med_scr_item_name = ?" ;
                stmt = con.prepareStatement (sql);
				stmt.setString(1, curr_ds_id ) ;
                stmt.setString(2, scr_item_name ) ;

                rset = stmt.executeQuery();	               
                String ds_col_name = "";
                if(rset !=null)
                {
                    if(rset.next())
                    {
                        ds_col_name = rset.getString(1) ;
                        if(rset != null)  rset.close() ;
                        if(stmt != null)  stmt.close() ;

                        sql  = "select "+ds_col_name+" from mp_patient_hcs_data where "+ds_col_name+"= ? " ;
                        stmt = con.prepareStatement (sql);
                        stmt.setString(1, scr_item_value ) ;

                        rset = stmt.executeQuery();
                       
                        if(rset != null)
                        {
                            if(rset.next())
                            {
                                if(rset != null)  rset.close() ;
                                if(stmt != null)  stmt.close() ;

                                sql =" select med_col_name, med_col_datawidth,med_col_datadec, dsrc_col_datawidth,dsrc_col_datatype,dsrc_col_name, med_scr_item_name, override_yn,med_scr_legend from mp_datasource_mapping_vw where datasource_id = ? " ;
                                stmt = con.prepareStatement (sql);
                                stmt.setString(1, curr_ds_id ) ;

                                rset = stmt.executeQuery() ;
                               // out.println(sql);
                                if( rset!= null ){
                                     ret_script += ("//from here\nif(prev_set_objs !=null)\n");
                                     ret_script += ("{\n");
                                        ret_script += ("for(i =0;i<prev_set_objs.length;i++)\n");
                                         ret_script += ("{\n");
                                         ret_script += ( "if(prev_set_objs[i] != null){" ) ;
                                            ret_script += ("prev_set_objs[i].value = ''\n");
                                            
                                            ret_script += ("if(prev_set_objs[i].name == 'first_name' || prev_set_objs[i].name == 'second_name' || prev_set_objs[i].name == 'third_name' || prev_set_objs[i].name == 'family_name'||(prev_set_objs[i].name).indexOf('oth_lang')!= -1){\n") ;
                                            ret_script += ("parent.f_query_add_mod.patient_sub.ChangeInitCase(prev_set_objs[i])\n") ;
                                            ret_script += ("parent.f_query_add_mod.patient_sub.putPatientName(prev_set_objs[i])}\n") ;
                                            
                                               ret_script += ("if(prev_set_objs[i].name.indexOf('oth_lang') != -1) \n");
                                               ret_script += ("parent.f_query_add_mod.patient_sub.putLocalLangPatientName(obj) \n");

											  ret_script += ( "if( prev_set_objs[i].name == 'date_of_birth'){\n" );
                                              ret_script += ("parent.f_query_add_mod.patient_sub.gotoNext( prev_set_objs[i])\n") ;
                                              ret_script += ("parent.f_query_add_mod.patient_sub.document.getElementById('age_or_dob').disabled = false;}");

                                            ret_script += ("if(prev_set_objs[i].type == 'text')\n");
                                                ret_script += ("prev_set_objs[i].readOnly = false ;\n");
                                            ret_script += ("else\n") ;
                                                 ret_script += ("prev_set_objs[i].disabled = false ;\n");
                                         ret_script += ("}\n");
                                     ret_script += ("}}\n//end here"); 

                                    sql = "select ";
                                    ArrayList screen_items = new ArrayList() ;
                                    ArrayList legends = new ArrayList() ;
                                    while(rset.next())
                                    {
                                        if(rset.getString("DSRC_COL_DATATYPE").equals("D"))
                                            sql += " nvl(to_char("+rset.getString("dsrc_col_name")+",'dd/mm/yyyy'),'')" +"  "+  rset.getString("med_scr_item_name")+", " ;
                                        else
                                            sql += "substr("+rset.getString("dsrc_col_name") +",1,"+rset.getString("med_col_datawidth")+")  "+  rset.getString("med_scr_item_name")+", " ;

                                        if(rset.getString("override_yn").equals("N"))
                                        {
                                            screen_items.add(rset.getString("med_scr_item_name") );
                                        }
                                        
                                        legends.add(rset.getString("med_scr_legend")) ;
                                    }
                                    return_hash.put("disable_items",screen_items) ;
                                    return_hash.put("legends",legends);

                                    if(sql.indexOf(',')!= -1)
                                        sql = sql.substring(0,sql.lastIndexOf(',')) ;

                                    sql += " from  mp_patient_hcs_data where "+ds_col_name+"= ? " ;
                                    
//									 out.println(sql); 
                                    if(rset != null)  rset.close() ;
                                    if(stmt != null)  stmt.close() ;

                                    stmt = con.prepareStatement (sql);
                                    stmt.setString(1,scr_item_value);
                                    rset = stmt.executeQuery();
                                    
                                    java.sql.ResultSetMetaData rsmd = rset.getMetaData();
                                    String cols[] = new String[rsmd.getColumnCount()] ;

                                    if(rset.next()){
                                        for(int i=1; i<=rsmd.getColumnCount();i++){
                                            cols[i-1] = (rsmd.getColumnName(i).toLowerCase()) +"`"+ (rset.getString(i)==null ? " ": rset.getString(i)) ;
                                        }
                                        return_hash.put("disp_vals",cols);
                                    }
                                    if(rset != null)  rset.close() ;
                                }
                                return_hash.put("Return_Script",ret_script);								
                           }
                        }
                    }
                }
            }
        }
        catch(Exception e){try{out.println(e+":"+sql);}catch(Exception e1){}
        }
        finally
        {
            try
            {
            if( stmt != null )  stmt.close() ;
            if( rset != null )  rset.close() ;
            }catch(Exception e){}
        }
        return return_hash ;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);


	String alt_id1_type						= "";
	String nat_id_check_digit_id			= "";
	String KeyVal							= "";
	String nat_id_onKeyPress							= "";
	String alt_id1_accept_alphanumeric_yn	= "N";
	String nat_id_accept_alphanumeric_yn	= "N";
	/*Added by Thamizh selvi on 1st Aug 2018 for ML-MMOH-CRF-1177 Start*/
	JSONObject dobJSONObj = new JSONObject();
	String dateOfBirthNOK = "";
	String resDOB		  = "";
	String errMesg		  = "";
	/*End*/
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn			= null;
	java.sql.Statement stmt = null;
	ResultSet rs			= null;
	boolean flag = true ;
	int natIDCountInMPPatTable=1;
	String deceased_yn="N";
	try
	{
		conn	= ConnectionManager.getConnection(request);
		stmt	= conn.createStatement();
		
		String sql ;
		String function = checkForNull(request.getParameter("step"));
		String calledFunction = checkForNull(request.getParameter("calledFunction"));
		String from_newBorn = checkForNull(request.getParameter("from_newBorn"),"N");
		String isNatIdAltIdMandVisaType = request.getParameter("isNatIdAltIdMandVisaType");
		if(isNatIdAltIdMandVisaType==null)
			isNatIdAltIdMandVisaType="false";
		String dftNationalId = checkForNull(request.getParameter("dftNationalId"),"");
	
		//out.println("function :'"+function+"'");
		if(function.equals("first"))
		{
			sql = "SELECT dflt_pat_ser_grp_type, nat_id_length, NVL (nat_id_chk_len, 'N') nat_id_chk_len, NVL (nat_id_prompt, 'National ID No') nat_id_prompt, b.long_desc alt_id1_type, alt_id1_length, alt_id1_len_validation_yn, alt_id1_routine_yn,     alt_id1_data_source_id alt_id1_routine, alt_id1_chk_digit_scheme, alt_id1_unique_yn, alt_id1_accept_alphanumeric_yn, nat_id_accept_alphanumeric_yn, nat_id_check_digit_id FROM mp_param_lang_vw a, mp_alternate_id_type b WHERE a.alt_id1_type = b.alt_id_type and language_id='"+localeName+"' and module_id='MP'";

			rs = stmt.executeQuery(sql);

			if(!rs.next())
				response.sendRedirect("../../eCommon/jsp/error.jsp?err_num=No Record found in MP Parameter table");
			else
			{
				alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn");
				nat_id_accept_alphanumeric_yn = rs.getString("nat_id_accept_alphanumeric_yn");
				if(alt_id1_accept_alphanumeric_yn == null) alt_id1_accept_alphanumeric_yn = "N";
				if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";

					KeyVal = rs.getString("dflt_pat_ser_grp_type");
					nat_id_check_digit_id = checkForNull(rs.getString("nat_id_check_digit_id"));
				if(KeyVal.equals("N"))
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("nat_id_prompt")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("nat_id_prompt")));
            _bw.write(_wl_block11Bytes, _wl_block11);

				   String nat_id_val = checkForNull(request.getParameter("National_Id_No")) ;
				   if(nat_id_val == null)   nat_id_val = "";
				   if(nat_id_val.equals("null") )nat_id_val  = "";  
				   

			
					out.println("<body onKeyDown='lockKey()'><br><form name='nat_form' id='nat_form' method='post' action='../../eMP/jsp/checkNationality.jsp?step=second' target='errMsg'><table width='100%' cellspacing='0' cellpadding='0'><tr><td colspan='2'>&nbsp;</td></tr><tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDHolder.label","mp_labels")+"</td><td width='60%' align='left'>&nbsp;&nbsp;<input type='checkbox' name='nat_holder_yn' id='nat_holder_yn' onclick='checkBoxClicked()' value='' checked><input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='"+nat_id_accept_alphanumeric_yn+"'></td></tr>");

					/*
					if ( nat_id_check_digit_id.equals("M11") )
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
					else
							nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
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

					out.println("<tr><td align='right' width='40%' class='label' id='nat_prompt_id'>"+rs.getString("nat_id_prompt")+"</td><td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' name='nat_id_no' id='nat_id_no' onBlur='checkXInNatID(this);'  value=\""+nat_id_val +"\"  onKeyPress='return "+nat_id_onKeyPress+"'  size='20' maxlength='"+rs.getInt("nat_id_length")+"'  ><input type='hidden' name='group' id='group' value='N'></input><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value=\""+rs.getString("nat_id_prompt")+"\"></input><input type='hidden' name='output' id='output' value='W'></input></td></tr>");

					out.println("<tr><td colspan='2'>&nbsp;</td></tr><tr><td colspan='2' align='center'><input type='Button' name='ok' id='ok' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")+"' class='Button' onclick=\"submitAll('"+rs.getString("nat_id_chk_len")+"')\">&nbsp;&nbsp;<input type='Button' name='cancel' id='cancel' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+"' class='Button' onclick='CancelModal()'></td></tr><tr><td colspan='2'>&nbsp;</td></tr></table>");
					out.println("<input type='text' name='nat_id_no_for_disp' id='nat_id_no_for_disp'></input><input type='hidden' name='step' id='step' value='second'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value=''+nat_id_check_digit_id+''>") ;
					out.println("</form><script>document.getElementById('nat_id_no_for_disp').style.visibility='hidden';document.getElementById('nat_id_no').focus();</script></body></html>");
	
					if(stmt != null) stmt.close();

				} // End of FIRST INTERNAL IF

				if(KeyVal.equals("A"))
				{
					
            _bw.write(_wl_block12Bytes, _wl_block12);

							alt_id1_type = rs.getString("alt_id1_type");
							
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block20Bytes, _wl_block20);

						String alt_id_val = checkForNull(request.getParameter("alt_id"));
						if(alt_id_val == null)alt_id_val ="";
						if(alt_id_val.equals("null"))   alt_id_val ="" ;
						out.println("<body onKeyDown='lockKey()'><br><form name='alt_form' id='alt_form' method='post' action='../../eMP/jsp/checkNationality.jsp?step=second&routine_chk="+rs.getString("alt_id1_routine_yn")+"&routine_name="+rs.getString("alt_id1_routine")+"' target='msgFrame'><table width='100%' align='center' cellspacing='0' cellpadding='0' border='0'><tr><td colspan='2'>&nbsp;</td></tr><tr><td align='right' width='40%' class='label'>"+rs.getString("alt_id1_type")+" Holder</td><td width='60%' align='left'>&nbsp;&nbsp;<input type='checkbox' name='alt_holder_yn' id='alt_holder_yn' value='' checked onclick='checkBoxClicked();'/></td></tr>");
						out.println("<tr><td align='right' width='40%' class='label'>"+ rs.getString("alt_id1_type") + " No</td>");

						out.println("<td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' name='alt_id_no' id='alt_id_no' value=\""+alt_id_val+"\" size='"+rs.getInt("alt_id1_length")+"' maxlength='"+rs.getInt("alt_id1_length")+"' onKeyPress='return CheckSplCharsAltID(event);' onBlur='chkForAltID1Length(this);SpeCharCheck(this); return makeValidString(this);'/><input type='hidden' name='group' id='group' value='A'/><input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value='"+alt_id1_accept_alphanumeric_yn+"'/></td></tr>");


						out.println("<tr><td colspan='2'>&nbsp</td></tr><tr><td colspan='2' align='center'><input type='button' name='ok' id='ok' Value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")+"' class='Button' onclick=\"submitAll('"+rs.getString("alt_id1_len_validation_yn")+"','"+rs.getString("ALT_ID1_UNIQUE_YN")+"')\"/>&nbsp;&nbsp;<input type='Button' name='cancel' id='cancel' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+"' class='Button' onclick='CancelModal()'/></td></tr><tr><td colspan='2'>&nbsp;<input type='hidden' name='alt_id_type' id='alt_id_type' value="+ rs.getString("alt_id1_type") + " No /></td></tr></table>");
						out.println("<input type='text' name='alt_id_no_for_disp' id='alt_id_no_for_disp'></input><input type='hidden' name='step' id='step' value='second'/><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'/><input type='hidden' name='alt_id1_length' id='alt_id1_length' value='"+rs.getInt("alt_id1_length")+"'/><input type='hidden' name='routine_chk' id='routine_chk' value=\""+rs.getString("alt_id1_routine_yn")+"\"/><input type='hidden' name='rouroutine_name' id='rouroutine_name' value=\""+rs.getString("alt_id1_routine")+"\"/>");
						out.println("</form><script>document.forms[0].alt_id_no_for_disp.style.visibility='hidden';document.forms[0].alt_id_no.focus()</script></body></html>");

						if(stmt != null) stmt.close();
					}
				}	
			}	

			//SECOND SET OF OPERATIONS STARTS HERE //
//out.println("<script>alert('function :"+function+"');</script>");
			if(function.equals("second"))
			{
				String nat_id_no = "";
				String nat_id_name ="";
				String ext_system_interface_yn ="N";
				String nat_data_source_id ="";
				String selected_id = checkForNull(request.getParameter("selected_id"));
				String validate_dup = checkForNull(request.getParameter("validate_dup"),"Y");
				String populateDOBYn = checkForNull(request.getParameter("populateDOBYn"),"N");//Added by Thamizh selvi on 1st Aug 2018 against ML-MMOH-CRF-1177
				//System.out.println("group :'"+request.getParameter("group")+"'");
//out.println("<script>alert('group "+request.getParameter("group")+"')</script>");
				//String validate_dup = checkForNull(request.getParameter("validate_dup"),"N");
				if(checkForNull(request.getParameter("group")).equals("N")   )
				{
					String outArea					= checkForNull(request.getParameter("output"));
				    nat_id_check_digit_id	= checkForNull(request.getParameter("nat_id_check_digit_id"));
			    	nat_id_no						= checkForNull(request.getParameter("nat_id_no"));
					nat_id_name					= checkForNull(request.getParameter("nat_id_name"));
					ext_system_interface_yn		= checkForNull(request.getParameter("ext_system_interface_yn"),"N");

					nat_data_source_id  = checkForNull(request.getParameter("routine_name"));

					String result = "Y";    

				    stmt = conn.createStatement();
				   //out.println("<script>alert('nat_id_check_digit_id "+nat_id_check_digit_id+"');</script>");
				   //out.println("<script>alert('nat_data_source_id "+nat_data_source_id+"');</script>");
				   //System.out.println("nat_id_check_digit_id :'"+nat_id_check_digit_id+"'");
				   //System.out.println("nat_data_source_id :'"+nat_data_source_id+"'");
				    //if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && ext_system_interface_yn.equals("N") && nat_data_source_id.equals(""))
				    if(nat_id_check_digit_id != null && !nat_id_check_digit_id.equals("") && nat_data_source_id.equals(""))
					{
						sql = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_check_digit_id+"' ";
						//out.println("<script>alert('"+sql+"');</script>");
				        rs = stmt.executeQuery(sql);
				        if(rs.next())
				        {
				            nat_id_check_digit_id = rs.getString(1);
  //out.println("<script>alert('nat_id_check_digit_id "+nat_id_check_digit_id+" "+nat_id_no+"');</script>");
  //System.out.println("nat_id_check_digit_id 2:'"+nat_id_check_digit_id+"'");
				            if(rs != null)  rs.close();

							sql	= "select "+nat_id_check_digit_id+"('"+nat_id_no+"') from dual";
					        rs = stmt.executeQuery(sql);
				     			if(rs.next())
								result = rs.getString(1);
				            if(rs != null)  rs.close();
						}
					}
				    if(rs != null)  rs.close();
 //out.println("<script>alert('result "+result+"');</script>");
 //out.println("<script>alert('validate_dup "+validate_dup+"');</script>");
 //System.out.println("result :'"+result+"'");
 //System.out.println("validate_dup :'"+validate_dup+"'");
					String dup_nat_id = checkForNull(request.getParameter("dup_nat_id"));
		            if(dup_nat_id == null)  dup_nat_id = "" ;
					
					
					if(result.equals("Y") ) // 2
					{
						if (validate_dup.equals("Y"))
						{
			            String duplicateSql = "select patient_id from mp_patient where national_id_no = '"+nat_id_no+"'";
						
					    stmt = conn.createStatement();
				        rs = stmt.executeQuery(duplicateSql);
//out.println("<script>alert('dup_nat_id "+dup_nat_id+"')</script>");
//out.println("<script>alert('nat_id_no "+nat_id_no+"')</script>");
//System.out.println("dup_nat_id :'"+dup_nat_id+"'");
//System.out.println("nat_id_no :'"+nat_id_no+"'");

						int inActiveNatIdCount	= eMP.MPCommonBean.getInactiveNatIdCnt(conn,nat_id_no); // Added by Dharma on 19th Dec 2018 against ML-MMOH-CRF-0723 [IN:062858]
						if((rs.next() && !dup_nat_id.equals(nat_id_no)) || inActiveNatIdCount > 0) // 1
				        {
						natIDCountInMPPatTable=0;
						String msgID	= "DUP_NAT_ID";
						if(inActiveNatIdCount > 0){
							msgID	= "NAT_ID_INACTIVE";
						}
						if(isNatIdAltIdMandVisaType.equals("true") && dftNationalId.equals(nat_id_no))
								{
									
								}
								else {
				           if(outArea.equals("W"))
							{
				                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><center><br><br>"+
							    "  <script>val1 = getMessage('"+msgID+"','MP'); "+
			                    "val1 = val1.replace('#','"+checkForNull(request.getParameter("nat_id_prompt"))+"');"+
						        "document.write(val1)</script>"+
				                "<br><br><center><input type='Button' name='back' id='back' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")+"' class='Button'  onclick=\"callPrev('N')\" ></center></body></html>");
							}
				            else if(outArea.equals("A"))
							{
								natIDCountInMPPatTable=0;
								
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(from_newBorn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(msgID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nat_id_name));
            _bw.write(_wl_block25Bytes, _wl_block25);

							}
								}
						} else if(!dup_nat_id.equals(nat_id_no))
						{//out.println("<script>alert('dup_nat_id and nat_id_no are not equal:')</script>");
						//System.out.println("dup_nat_id and nat_id_no are not equal:");
				            out.println("<body class='message' onKeyDown='lockKey()'>");
				            String from_pat= request.getParameter("from_pat"); 
							String Site = request.getParameter("Site") ;
							String def_nat_id  = request.getParameter("def_nat_id") ;
							String routine_name  = request.getParameter("routine_name");
							if (routine_name==null) routine_name="";
							String nat_routine = "N";
							int natcnt=0;
							
							Properties p				=	(java.util.Properties) session.getValue("jdbc");
							String userId				= (String)session.getAttribute("login_user");
							HashMap hashMap12		= new HashMap();
							
							
							
							hashMap12 = eMP.ChangePatientDetails.getSetupData((String)session.getValue("facility_id"),"",conn,p);
							String pat_ser_access_by_user_yn = checkForNull((String)hashMap12.get("PAT_SER_ACCESS_BY_USER_YN"));
							String userAccessSql	= "";
							
						
							if(pat_ser_access_by_user_yn.equals("Y")){
								userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"') ";
							}
							
							
							
							rs = stmt.executeQuery("select pat_ser_grp_code from mp_pat_ser_grp where id_type = 'N' and id_type not in ('R', 'X') and pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S','"+Site+"','F','"+(String)session.getValue("facility_id")+"') and used_status = 'N' ) "+userAccessSql+" ");
						
							
							
							if(rs.next())
								natcnt = 1;
							if(routine_name.equals("NRIC"))
							{
								routine_name = "VERIFY_NATIONAL_ID";
								nat_routine = "Y";
							}
							if(rs!=null) rs.close();
							//if(stmt!=null) stmt.close();
//out.println("<script>alert('from_pat "+from_pat+"')</script>");
//out.println("<script>alert('from_newBorn "+from_newBorn+"')</script>");
//out.println("<script>alert('routine_name "+routine_name+"')</script>");
//System.out.println("from_pat :'"+from_pat+"'");
//System.out.println("from_newBorn :'"+from_newBorn+"'");
//System.out.println("routine_name :'"+routine_name+"'");
//System.out.println("outArea :"+outArea);
							if ( (from_pat != null) && (!from_newBorn.equals("Y") ) )
							{
									if(routine_name.equals("VERIFY_NATIONAL_ID") && nat_routine.equals("Y"))
									{
										String result1 = "";
										String error_message = "";
										String date_of_birth = "";
										//stmt = con.prepareStatement("select VERIFY_NATIONAL_ID('"+nat_id_no+"') FROM DUAL");
										rs = stmt.executeQuery("select VERIFY_NATIONAL_ID('"+nat_id_no+"') FROM DUAL");
										if (rs.next())
											result1 = rs.getString(1);
										
										StringTokenizer strTok = new StringTokenizer(result1,"$");
												
										String age_in_years  = "";
										String age_in_months = "";
										String age_in_days   = "";
										String sex = "";
										String place_of_birth_code="";
										String place_of_birth_desc = "";				
										if (strTok.hasMoreTokens())
											result1 = strTok.nextToken();
										
										if ( result1.equals("TRUE") ){
											if (strTok.hasMoreTokens())
												date_of_birth = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												age_in_years = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												age_in_months = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												age_in_days = strTok.nextToken();	
											if (strTok.hasMoreTokens())
												sex = strTok.nextToken();
											if (strTok.hasMoreTokens())
												place_of_birth_code = strTok.nextToken();
											if (strTok.hasMoreTokens())
												place_of_birth_desc = strTok.nextToken();
											if (!localeName.equals("en"))
											{
												date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",localeName); 
											}
											//ADDED for ML-MMOH-SCF-3108
											String sDate_of_birth = checkForNull(request.getParameter("Birth_Date"));
											System.out.println("sDate_of_birth=========================>"+sDate_of_birth);
											String[] parts = sDate_of_birth.split(" ");
											String time = parts.length > 1 ? parts[1] : ""; 
											System.out.println("Extracted Time: " + time); // END ML-MMOH-SCF-3108
											
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(date_of_birth +" "+ time));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(age_in_years));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(age_in_months));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(age_in_days));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(place_of_birth_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(place_of_birth_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(place_of_birth_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(place_of_birth_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);

										}
										else if ( result1.equals("FALSE") ){
											if(strTok.hasMoreTokens()) 
												error_message = strTok.nextToken();
												flag = false ;
											
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block38Bytes, _wl_block38);

										}else{
											if (strTok.hasMoreTokens())
												error_message = strTok.nextToken();
											out.println("alert(\""+error_message+"\")");											
											flag = false ;
										}
										strTok = null;
									}
									//out.println("<script>alert('flag before "+flag+"')</script>");
									//out.println("<script>alert('natIDCountInMPPatTable before "+natIDCountInMPPatTable+"')</script>");
									//System.out.println("flag :'"+flag+"'");
									//System.out.println("natIDCountInMPPatTable :'"+natIDCountInMPPatTable+"'");
									if(flag || natIDCountInMPPatTable==1){
										/*Bru-HIMS-CRF-124 starts*/
										/*Bru-HIMS-CRF-124 ends*/
										String xf_personSQL="select NATIONAL_ID_NO,EXT_PAT_ID,EHIS_PAT_ID,ALT_ID1_TYPE,ALT_ID1_NO,TO_CHAR (ALT_ID1_EXP_DATE, 'dd/mm/yyyy')ALT_ID1_EXP_DATE,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,FAMILY_NAME_PREFIX,NAME_SUFFIX,SEX GENDER,to_char(DATE_OF_BIRTH, 'dd/mm/yyyy') DATE_OF_BIRTH,NATIONALITY_CODE,(CASE WHEN NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(NATIONALITY_CODE,'"+localeName+"',3)) END ) nationality_desc,RACE_CODE,(CASE WHEN RACE_CODE IS NOT NULL THEN (mp_get_desc.mp_race(RACE_CODE,'"+localeName+"',2)) END ) RACE_DESC,RELIGION_CODE, (CASE WHEN RELIGION_CODE IS NOT NULL THEN (mp_get_desc.mp_religion(RELIGION_CODE,'"+localeName+"',2)) END ) RELIGION_DESC,RES_ADDR_LINE_1,RES_ADDR_LINE_2,RES_ADDR_LINE_3,RES_ADDR_LINE_4,RES_TOWN_CODE,(CASE WHEN RES_TOWN_CODE IS NOT NULL  THEN (mp_get_desc.mp_res_town(RES_TOWN_CODE,'"+localeName+"',2)) END ) RES_TOWN_DESC,RES_AREA_CODE,(CASE WHEN RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.mp_res_area(RES_AREA_CODE,'"+localeName+"',2)) END ) RES_AREA_DESC,RES_REGION_CODE,(CASE WHEN RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.mp_region(RES_REGION_CODE,'"+localeName+"',2)) END ) RES_REGION_DESC,RES_POSTAL_CODE,mp_get_desc.mp_postal_code(RES_POSTAL_CODE,'"+localeName+"',2) RES_POSTAL_DESC,RES_COUNTRY_CODE, (CASE WHEN RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.mp_country(RES_COUNTRY_CODE,'"+localeName+"',1)) END ) RES_COUNTRY_DESC,DECEASED_YN,DOC1_TYPE,(CASE WHEN DOC1_TYPE IS NOT NULL THEN(mp_get_desc.mp_document_type(DOC1_TYPE, '"+localeName+"', 2)) END) DOC1_TYPE_DESC,DOC1_NUM,TO_CHAR(DOC1_EXP_DATE, 'DD/MM/YYYY')DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,TO_CHAR(DOC1_ISS_DATE, 'DD/MM/YYYY') DOC1_ISS_DATE,STATUS from xf_person where national_id_no='"+nat_id_no+"'";
										//System.out.println("checkNationality.jsp xf_personSQL:"+xf_personSQL);
										if(rs!=null)rs.close();
										rs = stmt.executeQuery(xf_personSQL);
										if(rs!=null && rs.next()){
										String alt_id1_tyep=rs.getString("ALT_ID1_TYPE")==null?"":rs.getString("ALT_ID1_TYPE");
										String alt_id1_no=rs.getString("ALT_ID1_NO")==null?"":rs.getString("ALT_ID1_NO");
										String alt_id1_exp_date=rs.getString("ALT_ID1_EXP_DATE")==null?"":rs.getString("ALT_ID1_EXP_DATE");
										String name_prefix=rs.getString("NAME_PREFIX")==null?"":rs.getString("NAME_PREFIX");
										String first_name=rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
										String second_name=rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
										String third_name=rs.getString("THIRD_NAME")==null?"":rs.getString("THIRD_NAME");
										String family_name=rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
										String family_name_prefix=rs.getString("FAMILY_NAME_PREFIX")==null?"":rs.getString("FAMILY_NAME_PREFIX");
										String name_suffix=rs.getString("NAME_SUFFIX")==null?"":rs.getString("NAME_SUFFIX");
										String gender=rs.getString("GENDER")==null?"":rs.getString("GENDER");
										String date_of_birth=rs.getString("date_of_birth")==null?"":rs.getString("date_of_birth");
										String nationality_code=rs.getString("NATIONALITY_CODE")==null?"":rs.getString("NATIONALITY_CODE");
										String nationality_desc=rs.getString("NATIONALITY_DESC")==null?"":rs.getString("NATIONALITY_DESC");
										String race_code=rs.getString("RACE_CODE")==null?"":rs.getString("RACE_CODE");
										String race_desc=rs.getString("RACE_DESC")==null?"":rs.getString("RACE_DESC");
										String religion_code=rs.getString("RELIGION_CODE")==null?"":rs.getString("RELIGION_CODE");
										String religion_desc=rs.getString("RELIGION_DESC")==null?"":rs.getString("RELIGION_DESC");
										String res_addr_line_1=rs.getString("res_addr_line_1")==null?"":rs.getString("res_addr_line_1");
										String res_addr_line_2=rs.getString("res_addr_line_2")==null?"":rs.getString("res_addr_line_2");
										String res_addr_line_3=rs.getString("res_addr_line_3")==null?"":rs.getString("res_addr_line_3");
										String res_addr_line_4=rs.getString("res_addr_line_4")==null?"":rs.getString("res_addr_line_4");
										String res_town_code=rs.getString("RES_TOWN_CODE")==null?"":rs.getString("RES_TOWN_CODE");
										String res_town_desc=rs.getString("RES_TOWN_DESC")==null?"":rs.getString("RES_TOWN_DESC");
										String res_area_code=rs.getString("RES_AREA_CODE")==null?"":rs.getString("RES_AREA_CODE");
										String res_area_desc=rs.getString("RES_AREA_DESC")==null?"":rs.getString("RES_AREA_DESC");
										String res_region_code=rs.getString("RES_REGION_CODE")==null?"":rs.getString("RES_REGION_CODE");
										String res_region_desc=rs.getString("RES_REGION_DESC")==null?"":rs.getString("RES_REGION_DESC");
										String res_postal_desc=rs.getString("RES_POSTAL_DESC")==null?"":rs.getString("RES_POSTAL_DESC");
										String res_country_code=rs.getString("RES_COUNTRY_CODE")==null?"":rs.getString("RES_COUNTRY_CODE");
										String res_country_desc=rs.getString("RES_COUNTRY_DESC")==null?"":rs.getString("RES_COUNTRY_DESC");
										String doc1_type=rs.getString("DOC1_TYPE")==null?"":rs.getString("DOC1_TYPE");
										String doc1_type_desc=rs.getString("DOC1_TYPE_DESC")==null?"":rs.getString("DOC1_TYPE_DESC");
										String doc1_num=rs.getString("DOC1_NUM")==null?"":rs.getString("DOC1_NUM");
										String doc1_exp_date=rs.getString("DOC1_EXP_DATE")==null?"":rs.getString("DOC1_EXP_DATE");
										String doc1_place_of_issue=rs.getString("DOC1_PLACE_OF_ISSUE")==null?"":rs.getString("DOC1_PLACE_OF_ISSUE");
										String doc1_iss_date=rs.getString("DOC1_ISS_DATE")==null?"":rs.getString("DOC1_ISS_DATE");
										deceased_yn=rs.getString("DECEASED_YN")==null?"N":rs.getString("DECEASED_YN");
										
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(family_name_prefix));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(res_addr_line_1));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(res_addr_line_2));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(res_addr_line_3));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_addr_line_4));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(res_region_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(res_postal_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(doc1_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(doc1_type_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(doc1_num));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(doc1_exp_date));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(doc1_place_of_issue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(doc1_iss_date));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
										
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(Site));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(def_nat_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(nat_id_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(nat_routine));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(nat_id_name));
            _bw.write(_wl_block84Bytes, _wl_block84);

												if( !routine_name.equals(""))
													out.println("<input type='hidden' name='curr_ds_id' id='curr_ds_id' value=\""+routine_name+"\">") ;
												
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(selected_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(natcnt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(selected_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(natcnt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(selected_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(natcnt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(calledFunction));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(from_newBorn));
            _bw.write(_wl_block92Bytes, _wl_block92);

											if(!routine_name.equals("")) { 
            _bw.write(_wl_block93Bytes, _wl_block93);
 } 
            _bw.write(_wl_block94Bytes, _wl_block94);

										if(!routine_name.equals("")) { 
            _bw.write(_wl_block95Bytes, _wl_block95);
 } 
            _bw.write(_wl_block96Bytes, _wl_block96);

							  }
							} else {
				                if(outArea.equals("W"))
								{
				                   
								   out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'> 	let dialogBody = parent.parent.document.getElementById('dialog-body');   dialogBody.contentWindow.returnValue = 'N"+nat_id_no+"'; const dialogTag = parent.parent.document.getElementById('dialog_tag');     dialogTag.close();</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></BODY></HTML>");
								}
							    else if(outArea.equals("A"))
								{
					                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>parent.f_query_add_mod.patient_sub.document.getElementById('nat_id_val').value ='T';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>");
								}
							}
				            // End of 1
						}
						else
						{
							
            _bw.write(_wl_block97Bytes, _wl_block97);
/*Added by Thamizh selvi on 2nd Aug 2018 for ML-MMOH-CRF-1177 Start*/
								if(("Y").equals(populateDOBYn)){
									dobJSONObj		= eMP.MPCommonBean.getDOBFrmNationalityId(conn, nat_id_no);
									dateOfBirthNOK	= (String)dobJSONObj.get("dateOfBirth");
									resDOB			= (String)dobJSONObj.get("result");
									errMesg			= (String)dobJSONObj.get("errorMsg");
								}
								
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(populateDOBYn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(resDOB));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(dateOfBirthNOK));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(dateOfBirthNOK));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(resDOB));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(errMesg));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(errMesg));
            _bw.write(_wl_block105Bytes, _wl_block105);

						}
				    } // End of 2
				    else
					{
//out.println("<script>alert('outArea "+outArea+"')</script>");
						
					    if(outArea.equals("W"))
						{
							    out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><center><br><br>"+
							    "  <script>val1 = getMessage('INVALID_NAT_ID','MP'); "+
			                    "val1 = val1.replace('#','"+request.getParameter("nat_id_prompt")+"');"+
						        "document.write(val1)</script>"+
				                "<br><br><center><input type='Button' name='back' id='back' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")+"' class='Button'  onclick=\"callPrev('N')\" ></center></body></html>");
						}
					    else if(outArea.equals("A"))
						{
							
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(from_newBorn));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(nat_id_name));
            _bw.write(_wl_block109Bytes, _wl_block109);

						}
					}
					if(stmt != null) stmt.close();
				} // Second IF-ELSE End
				if(request.getParameter("group").equals("A"))
				{
					String alt_id_no = request.getParameter("alt_id_no");
					out.println(alt_id_no);
					String alt_id_check_digit = request.getParameter("alt_id1_chk_digit_scheme");

					stmt = conn.createStatement();
				    result = "TRUE";
    
				    if(alt_id_check_digit != null)
				    {
				        sql = "select program_name from mp_check_digit_scheme where scheme_id='"+alt_id_check_digit+"'" ;
					    rs = stmt.executeQuery(sql);
					    if(rs.next())
				        {
				            alt_id_check_digit = rs.getString(1);
							if(rs != null)  rs.close();
							sql = "select "+alt_id_check_digit+"('"+alt_id_no+"') from dual";
							rs = stmt.executeQuery(sql);
				            if(rs.next())
				                result = rs.getString(1);
				            if(rs != null)  rs.close();
						}
					}
				    if(rs != null)  rs.close();
				    String alt_unique = request.getParameter("alt_unique") ;
				    if(alt_unique == null) alt_unique = "N" ;
				    if(result.equals("Y") && alt_unique.equals("Y")) // 2
					{
				        stmt = conn.createStatement();
						String duplicateSql = "select patient_id from mp_patient where alt_id1_no = '"+ alt_id_no+"'";
				        stmt = conn.createStatement();
				        rs = stmt.executeQuery(duplicateSql);
						if(rs.next()) // 1
						{
				            out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><br><br><center><SCRIPT>var val=getMessage('DUP_ALT_ID','MP');val = val.replace('$','"+request.getParameter("alt_id_type")+"');document.writeln(val);</SCRIPT><br><br><input type='Button' class='Button' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")+"'  name='back' id='back' onclick=\"callPrev('A')\"></center></body></html>");
						}
						else
						{
							if(request.getParameter("routine_chk").equals("Y"))
							{
								String curr_ds_id = request.getParameter("routine_name") ;
								HashMap ret_hash = HealthCardData(conn,curr_ds_id, "alt_id1_no",alt_id_no,out,"") ;            
								if(!ret_hash.isEmpty()) {
				
								out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body');    dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"';    const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>");	}								
								else {
									
								out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body');   dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"';   const dialogTag = parent.parent.document.getElementById('dialog_tag');  dialogTag.close();   </script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>"); }
							}
							else	{
			
							out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body'); dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"'; const dialogTag = parent.parent.document.getElementById('dialog_tag');   dialogTag.close();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>"); }
						} // End of 2
					}
					else
					{
						
						out.println("<head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><script language='javascript'>	let dialogBody = parent.parent.document.getElementById('dialog-body'); dialogBody.contentWindow.returnValue = 'A" + alt_id_no +"';    const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();   </script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></BODY></HTML>");
					}

					if(stmt != null) stmt.close();
				} // Second IF-ELSE End
			} // END OF 'A' Check
			if(rs != null) rs.close() ;
			if(stmt != null) stmt.close();
			// for smart card
			
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(from_newBorn));
            _bw.write(_wl_block111Bytes, _wl_block111);

			// for smart card
	}
		}
		catch(Exception e)
		{ 
			out.println(e);
			e.printStackTrace();
		}
		finally
		{
		     ConnectionManager.returnConnection(conn,request);
		}
		
            _bw.write(_wl_block112Bytes, _wl_block112);
            _bw.write(_wl_block113Bytes, _wl_block113);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Check.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Check.label", java.lang.String .class,"key"));
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
}
