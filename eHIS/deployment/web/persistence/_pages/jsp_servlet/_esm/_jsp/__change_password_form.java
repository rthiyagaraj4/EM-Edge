package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __change_password_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/change_password_form.jsp", 1719395103100L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script language=\"JavaScript\">\nfunction CheckForSpecCharsforID(event){\n\t//if(document.getElementById(\'changepwdfor\').value!=\'L\'){\n\t\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\t\treturn true ;\n//\t}\n}\n//Maheshwaran modified for the MMS-QH-CRF-0149\nfunction CheckSpecialChar(obj,enforce_password_policy_yn,allowed_spl_char_in_password)\n{\n\tvar fieldval = obj.value;\n\tvar fieldlen = fieldval.length;\n\tvar to_check = true;\n\tvar SpChar = new Array();\n\tvar allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\tallowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace(\"+\",\'\');\n\tvar changepwdfor=document.change_password_form.changepwdfor.value;\t\n\t//Maheshwaran added for the MMS-QH-CRF-0149\n\tif((enforce_password_policy_yn==\'Y\')&&(changepwdfor==\'L\'))\n\t\t{\n\t\tSpChar[0] = \'!\';\n\t\tSpChar[1] = \'#\';\n\t\tSpChar[2] = \'%\';\n\t\tSpChar[3] = \'&\';\n\t\tSpChar[4] = \'(\';\n\t\tSpChar[5] = \')\';\n\t\tSpChar[6] = \'+\';\n\t\tSpChar[7] = \'=\';\n\t\tSpChar[8] = \'|\';\n\t\tSpChar[9] = \'\\\\\';\n\t\tSpChar[10] = \'{\';\n\t\tSpChar[11] = \'}\';\n\t\tSpChar[12] = \':\';\n\t\tSpChar[13] = \';\';\n\t\tSpChar[14] = \'\"\';\n\t\tSpChar[15] = \'<\';\n\t\tSpChar[16] = \'>\';\n\t\tSpChar[17] = \'/\';\n\t\tSpChar[18] = \'\\\'\';\n\t\tSpChar[19] = \'\';\n\t\tSpChar[20] = \',\';\n\t\tSpChar[21] = \'.\';\n\t\tSpChar[22] = \'@\';\n\t\t}\n\telse{\n\t\tSpChar[0] = \'~\';\n\t\tSpChar[1] = \'`\';\n\t\tSpChar[2] = \'!\';\n\t\tSpChar[3] = \'@\';\n\t\tSpChar[4] = \'#\';\n\t\tSpChar[5] = \'$\';\n\t\tSpChar[6] = \'%\';\n\t\tSpChar[7] = \'^\';\n\t\tSpChar[8] = \'&\';\n\t\tSpChar[9] = \'*\';\n\t\tSpChar[10] = \'(\';\n\t\tSpChar[11] = \')\';\n\t\tSpChar[12] = \'-\';\n\t\tSpChar[13] = \'+\';\n\t\tSpChar[14] = \'=\';\n\t\tSpChar[15] = \'|\';\n\t\tSpChar[16] = \'\\\\\';\n\t\tSpChar[17] = \'[\';\n\t\tSpChar[18] = \']\';\n\t\tSpChar[19] = \'{\';\n\t\tSpChar[20] = \'}\';\n\t\tSpChar[21] = \':\';\n\t\tSpChar[22] = \';\';\n\t\tSpChar[23] = \'\"\';\n\t\tSpChar[24] = \'<\';\n\t\tSpChar[25] = \'>\';\n\t\tSpChar[26] = \'?\';\n\t\tSpChar[27] = \'/\';\n\t\tSpChar[28] = \'\\\'\';\n\t\tSpChar[29] = \'\';\n\t\tSpChar[30] = \',\';\n\t\tSpChar[31] = \'.\';\n\t\t}\n\t\tif (fieldval.substr(0,1) == \'_\' ) \n\t{\n\t\tto_check = false;\n\t}\n\n\tfor (var i=0;i<fieldlen;i++)\n\t{\n\n\t\tif (fieldval.substr(i,1) == \' \' || fieldval.substr(i,1) == null)\n\t\t{\n\t\t\tto_check = false;\n\t\t}\n\t\t//Maheshwaran added for the MMS-QH-CRF-0149\n\t\tif((enforce_password_policy_yn==\'Y\')&&(changepwdfor==\'L\'))\n\t\t\t{\n\t\t\tfor (var j=0;j<=22;j++)\n\t\t\t\t{\n\t\t\t\tif (fieldval.substr(i,j) == SpChar[j])\n\t\t\t\t\t{\n\t\t\t\t\tto_check = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\t\t\n\t\telse\n\t\t\t{\n\t\t\tfor (var j=0;j<=31;j++)\n\t\t\t\t{\n\t\t\t\tif (fieldval.substr(i,j) == SpChar[j])\n\t\t\t\t\t{\n\t\t\t\t\tto_check = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t}\n\t\t\n\t\n\tif (to_check == false)\n\t{\t\n\t\t//Maheshwaran added for the MMS-QH-CRF-0149\n\t\tif((enforce_password_policy_yn==\'Y\')&&(changepwdfor==\'L\'))\n\t\t\t{\n\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password1));\n\t\t\t}\n\t\telse\n\t\t\t{\n\t\t\talert(getMessage(\'SPECIAL_CHARCTERS_NOT_ALLOWED\',\'SM\'));\n\t\t\t}\n\t\tobj.select();\n\t\tobj.focus();\n\t\tobj.value=\'\';\n\t}\n\n}\n\nfunction CheckForNumber(obj) \n{\n\tif (obj.value.length > 0 )\n\t{\n\t\t\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)\n\t\t\t{\t\t\n\t\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif (obj.value.substr(0,1) >= 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\t\n\tfunction checkLen_1(Obj) {\n\t\t\t/*var errors = \"\" ;\n\t\t\tvar len_one=Obj.value.length;\n\t\t\tif (len_one <5)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MIN_FIVE_CH\') ;\n\t\t\t\t\talert(errors);\n\t\t\t\t\tObj.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (len_one >20)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PW_EXCEED_MAX_LENGTH\') ;\n\t\t\t\t\talert(errors);\n\t\t\t\t\tObj.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\t\t\t\n\t\t\t\telse {\n\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t}*/\n\t\t\t}\n\t\t\nfunction checkLen_2(len)\n{\n\t\t\t/*var errors = \"\" ;\n\t\t\tvar len_two=len.value.length;\n\t\t\tif (len_two <5)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MIN_FIVE_CH\') ;\n\t\t\t\t\talert(errors);\n\t\t\t\t\tlen.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (len_two >20)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PW_EXCEED_MAX_LENGTH\') ;\n\t\t\t\t\talert(errors);\n\t\t\t\t\tlen.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{}*/\n}\n\t\t\n\t\n\t\nfunction enableDisableValues(obj){\n\n/*if(obj.value==\"A\")\n{\n\nchange_password_form.old_password.readOnly=true\nchange_password_form.document.getElementById(\"oldpwd\").style.visibility=\"hidden\"\nchange_password_form.old_password.value =\"\";;\nchange_password_form.new_password1.value=\"\" ;\nchange_password_form.new_password2.value =\"\";\n\n}else\n{*/\nchange_password_form.old_password.readOnly=false\nchange_password_form.document.getElementById(\"oldpwd\").style.visibility=\"visible\"\nchange_password_form.old_password.value =\"\";;\nchange_password_form.new_password1.value=\"\" ;\nchange_password_form.new_password2.value =\"\";\n\n/*}*/\n}\t\n\t//Maheshwaran added for the MMS-QH-CRF-0149\nfunction ChkPWSplChar(obj,allowed_spl_char_in_password)\n\t{\n\tvar value = obj.value;\n\tallowed_spl_char_in_password=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\tallowed_spl_char_in_password = allowed_spl_char_in_password.replace(\"+\",\'\')\n\tvar paswd1=/^[a-zA-Z](?=.*[0-9])/;\n\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\tstrCheck= strCheck.concat(allowed_spl_char_in_password);\n\tvar strCheck1 = \'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\tvar paswd4=/^[a-zA-Z]*$/;\n\tif(obj.value.match(paswd1))\n\t\t{\n\t\tfor (var i = 0; i < value.length; i++) \n\t\t\t{\n\t\t\tif (strCheck.indexOf(value.charAt(i)) == -1) \n\t\t\t\t{\n\t\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\t\tobj.value=\"\";\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t}\n\t\t}\n\telse if(value.match(paswd4))\n\t\t{\n\t\tif (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) \n\t\t\t{\n\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\tobj.value=\"\";\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\telse\n\t\t{\n\t\tfor (var i = 0; i < value.length; i++) \n\t\t\t{\n\t\t\tif (strCheck1.indexOf(value.charAt(i)) == -1) \n\t\t\t\t{\n\t\t\t\tif (allowed_spl_char_in_password.indexOf(value.charAt(i)) != -1) \n\t\t\t\t\t{\n\t\t\t\t\tif(value.indexOf(value.charAt(i))==0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\tif (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) \n\t\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\tobj.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t}\n\t}\nfunction spl_char_legend(obj,enforce_password_policy_yn)\n\t{\n\tif((obj.value==\'L\')&&(enforce_password_policy_yn==\'Y\'))\n\tdocument.getElementById(\'spl_char_legend_display\').style.display  = \'\';\n\telse\n\tdocument.getElementById(\'spl_char_legend_display\').style.display  = \'none\';\n\t}\t\nfunction ChangeUpperCase1(obj,change_pw)\n\t\t{\n\t\tif(change_pw.value!=\'L\')\n\t\t\t{\n\t\t\tChangeUpperCase(obj);\n\t\t\t}\n\t\t}\n\t//End\n</script>\n\n</head>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<body  class=\"CONTENT\" onLoad=\"\" onKeyDown = \'lockKey()\'>\n<center>\n\n\t<table width=\"100%\">\n\t\t<tr class=\"HEADER\">\n\t\t\t<td class=\"HEADER\" valign=\"top\" width=\"10%\">\n\t\t\t\t<!-- <img src=\"../../eCommon/images/orgLogo.gif\" vspace=0 hspace=0> -->\n\t\t\t\t<img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\" width=\"40\" height=\"40\">\n\t\t\t</td>\n\n\t\t\t<td class=\"HEADER\" valign=\"top\" width=\"65%\">\n\t\t\t\t<font size=\"-1\"><b>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</b></font>\n\t\t\t</td>\n\n\t\t\t<td class=\"HEADER\" valign=\"top\" width=\"15%\">\n\t\t\t\t<font size=\"-1\">\n\t\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t</b>\n\t\t\t\t</font>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t\n\n\t<form name=\"change_password_form\" id=\"change_password_form\" method=\"post\" action=\"../../servlet/eSM.ChangePasswordServlet\">\n\t\t<table width=\"90%\" cellpadding=\'0\' cellspacing=\'0\'>\n\t\t\t<!-- <tr><td colspan=\'2\'>&nbsp;</td></tr> -->\n\n\t\t\t<tr>\n\t\t\t\t<td width=\'50%\' class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\t\t\t\t</td>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"user\" id=\"user\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" readonly>\n\t\t\t\t</td>\n\t\t\t</tr>\n              \n       \t\t<tr>\n\t\t\t<td width=\'50%\' class=\'label\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</td>\n\t\t\t<td>&nbsp;\n\t\t\t<!--Maheshwaran modified for the MMS-QH-CRF-0149-->\n\t\t\t<SELECT name=\"changepwdfor\" id=\"changepwdfor\" onChange=\"enableDisableValues(this); spl_char_legend(this,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" > \n\t\t\t<option>----------";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="----------</option>\n\t\t\t\n\t\t\t<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t         <option value=\'S\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\t\n\t\t    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t         <option value=\'H\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t         <option value=\'PH\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t</td>\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t</td>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"password\" name=\"old_password\" id=\"old_password\" onBlur=\'ChangeUpperCase1(this,changepwdfor)\' readOnly maxlength=20 >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" id=\'oldpwd\' style=\"visibility:hidden\"align=\"center\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</td>\n\t\t\t\t<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"password\" name=\"new_password1\" id=\"new_password1\" maxlength=\"20\" onChange=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" if(document.change_password_form.changepwdfor.value==\'L\'){ ChkPWSplChar(this,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')}";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onkeypress=\'return checkMaxLimit(this,20)\' onBlur=\"\" onKeyUp=\" if(document.change_password_form.changepwdfor.value==\'L\'){ CheckSpecialChar(this,\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\', \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'); CheckForNumber(this);}\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" id=\'newpwd\' align=\"center\">\n\n\t\t\t\t\t<!--input type=\"password\" name=\"new_password1\" maxlength=\"20\" onChange=\"checkLen_1(this)\" onkeypress=\'return checkMaxLimit(this,20)\' onBlur=\"\" onKeyUp=\"CheckSpecialChar(this);CheckForNumber(this)\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" id=\'newpwd\' align=\"center\"-->\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  onChange=\'checkLen_2(this)\' onkeypress=\'checkMaxLimit(this,20)\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</td>\n\t\t\t\t<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"password\" name=\"new_password2\" id=\"new_password2\" maxlength=\"20\" onBlur=\"\" onChange=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onkeypress=\'return checkMaxLimit(this,20)\' onKeyUp=\" if(document.change_password_form.changepwdfor.value==\'L\'){ CheckSpecialChar(this,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'); CheckForNumber(this); }\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"  id=\'retypwd\'align=\"center\">\n\n\t\t\t\t\t<!--input type=\"password\" name=\"new_password2\" maxlength=\"20\" onBlur=\"\" onkeypress=\'return checkMaxLimit(this,20)\' onKeyUp=\"CheckSpecialChar(this);CheckForNumber(this)\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"  id=\'retypwd\'align=\"center\"-->\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'2\'>&nbsp;</td></tr>\n\t\t\t<tr id=\'spl_char_legend_display\' style=\'display:none\'>\n\t\t\t <td colspan=\'3\' class=\'label\' style=\'color:red\'><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</b>&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\n\t\t<br>\n\n\t\t<input type=\"hidden\" name=\"current_password1\" id=\"current_password1\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"hidden\" name=\"current_password\" id=\"current_password\" value=\"\">\n\t\t<input type=\"hidden\" name=\"main_yn\" id=\"main_yn\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t   \n\t\t<input type=\"hidden\" name=\"senpwd\" id=\"senpwd\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"hrpwd\" id=\"hrpwd\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\"pinpwd\" id=\"pinpwd\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n        <input type=\"hidden\" name=\"disppwd\" id=\"disppwd\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> \n\n\t\t<input type=\"hidden\" name=\"phCnt\" id=\"phCnt\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"mrCnt\" id=\"mrCnt\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"senCnt\" id=\"senCnt\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\" name=\"ph_install_yn\" id=\"ph_install_yn\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<!--\t//Maheshwaran added for the MMS-QH-CRF-0149-->\n\t\t<!--Start-->\n\t\t<input type=\'hidden\' name=\'allowed_spl_char_in_password\' id=\'allowed_spl_char_in_password\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=\'hidden\' name=\'enforce_password_policy_yn\' id=\'enforce_password_policy_yn\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t<input type=\'hidden\' name=\'case_sensitive_password_yn\' id=\'case_sensitive_password_yn\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t<!--<input type=\'hidden\' name=\'password_length_min\' id=\'password_length_min\' value=\'\'>\t\n\t\t<input type=\'hidden\' name=\'password_length_max\' id=\'password_length_max\' value=\'\'>-->\n\t\t<!--End-->\n\t\t<!--Added by Maheshwaran K for the Password Validation as on 11/07/2012\n\t\tStart-->\n\t\t<input type=\"hidden\" name=\"resp_group_id\" id=\"resp_group_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<!--End-->\n\t\t<input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' onClick=\'checkPassword()\'>&nbsp;&nbsp;\n\t\t<input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onClick=\"cancelClose()\">\n<script>\n\t\t\t\n\tfunction checkPassword() {\n\t//\tvar current_password\t= change_password_form.current_password.value ;\n\t\tvar current_password1\t= change_password_form.current_password1.value ;\n\t\tvar old_password\t\t= change_password_form.old_password.value ;\n\t\tvar new_password1\t\t= change_password_form.new_password1.value ;\n\t\tvar new_password2\t\t= change_password_form.new_password2.value ;\n\t//\tvar password_length_min\t\t= change_password_form.password_length_min.value ;//Maheshwaran added for the MMS-QH-CRF-0149\n\t//\tvar password_length_max\t\t= change_password_form.password_length_max.value ;//Maheshwaran added for the MMS-QH-CRF-0149\n\t\tvar case_sensitive_password_yn=change_password_form.case_sensitive_password_yn.value ;//Maheshwaran added for the MMS-QH-CRF-0149\n\t\tvar changepwdfor=change_password_form.changepwdfor.value ;\n        var phpwd =change_password_form.disppwd.value ;\n        var senpwd=change_password_form.senpwd.value ;\n        var hrpwd =change_password_form.hrpwd.value ;\n        var pinpwd=change_password_form.pinpwd.value ;\n\n\t\tvar errors\t\t\t= \"\" ;\n\t\tvar result\t\t\t= true ;\n\n\t\tif(changepwdfor==\"\")\n\t\t{\n\t\talert(getMessage(\'CHANGE_PWD_SELECT\',\'SM\'))\n\t\treturn false;\n\t\t}else if(changepwdfor==\"A\")\n\t\t{\n           \t\n\t\tif(new_password1==\"\"||new_password2==\"\")\n\t\t{\n\t\talert(getMesage(\'ENTER_PWD\',\'SM\'))\n\t\treturn false;\n\t\t}\n\n\t\t\n\t\tif ( new_password1.toUpperCase() != new_password2.toUpperCase() ) {\n\t\t    \n\t\t\terrors=getMessage(\'CONF_PASS_NOT_SAME_AS_NEW_PASS\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false;\n\t\t\t///result = false ;\n\t\t}\n\n\t\tif ( new_password1.length < 5 ) {\n\t\t\t\n\t\t\terrors=getMessage(\'MIN_LENGTH_5_CH\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false;\n\t\t}\n\t\tif ( new_password1.length > 20 ) {\n\t\t\t\n\t\t\terrors=getMessage(\'MAX_LENGTH_5_CH\',\'SM\');\n\t\t\terrors=errors.replace(\"5\",\"10\");\n\t\t\talert(errors)\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\t if(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' == \'N\')\n\t\t\t{\n\t\t\t\tvar html = \"<html><body onKeyDown = \'lockKey()\'><form name=\'dummyForSubmit\' id=\'dummyForSubmit\'  action=\'../../servlet/eSM.ChangePasswordServlet\' method=\'post\'>\";\n\t\t\t\tfor(var i=0;i<document.change_password_form.elements.length;i++)\n\t\t\t\t{\n\t\t\t\t\tvar n = document.change_password_form.elements(i).name;\n\t\t\t\t\tvar v = document.change_password_form.elements(i).value;\n\t\t\t\t\thtml += \"<input type=hidden name=\"+n+\" id=\"+n+\" value=\"+v+\">\";\n\t\t\t\t}\n\t\t\t\thtml+=\"</form></body></html>\";\n\t\t\t\tparent.frames[1].document.body.insertAdjacentHTML(\"AfterBegin\",html);\n\t\t\t\tparent.frames[1].document.dummyForSubmit.submit();\n\t\t\t}\n\t\t\telse\n\t\t\t\tdocument.change_password_form.submit() ;\n\t\t\n\n\n\t\t\n\t\t}else\n\t\t\t{\n\n\t\t                             \n\t\t if(changepwdfor==\'L\')         \n\t\t{  \n\t\t//Maheshwaran added for the MMS-QH-CRF-0149 \n\t\tif(case_sensitive_password_yn==\'N\')\n\t\t\t{\n\t\t\told_password=old_password.toUpperCase();\n\t\t\tcurrent_password1=current_password1.toUpperCase();\n\t\t\t}\n\t\tcurrent_password=current_password1  \n\t\tchange_password_form.current_password.value =current_password;\n\t\t\n\t\t}else if (changepwdfor==\'P\')\n\t\t{\n\t\tcurrent_password=pinpwd\n\t\tchange_password_form.current_password.value =current_password;\n\t\t}\n\t\telse if (changepwdfor==\'S\')\n\t\t{\n\t\tcurrent_password=senpwd;\n\t\tchange_password_form.current_password.value =current_password;\n\t\t}\n\t\telse if (changepwdfor==\'H\')\n\t\t{\n\t\tcurrent_password=hrpwd;\n\t\tchange_password_form.current_password.value =current_password;\n\t\t}else if (changepwdfor==\'PH\')\n\t\t{\n\t\tcurrent_password=phpwd;\n\t\tchange_password_form.current_password.value =current_password;\n\t\t}\n\t\t\n\t\tif ( current_password != old_password ) {\n\n\t\t\terrors=getMessage(\'INCORRECT_OLD_PW\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false;\n\t\t}\n\n\t\tif ( new_password1.toUpperCase() != new_password2.toUpperCase() ) {\n\t\t\t\n\t\t\terrors=getMessage(\'CONF_PASS_NOT_SAME_AS_NEW_PASS\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false;\n\t\t}\n\n\t\t\n\t\tif(changepwdfor!=\'P\')\n\t\t\t\t{\n\t\t\t\tif(changepwdfor==\'L\')\n\t\t\t\t\t{\n\t\t\t\t\tif ( new_password1.length < \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' ) {\n\t\t\t\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\t\t\t\terrors=errors.replace(\"#\",\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\n\t\t\t\t\t\talert(errors)\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\t{\t\t\n\t\t\t\t\tif ( new_password1.length < 5 ) {\n\t\t\t\t\t\terrors=getMessage(\'MIN_LENGTH_5_CH\',\'SM\');\n\t\t\t\t\t\talert(errors)\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t \n\t\t \n\t\t if(changepwdfor==\'L\') \n\t\t\t\t{\n\t\t\t\tif ( new_password1.length > \'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' ) {\n\t\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\t\terrors=errors.replace(\"#\",\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\');\n\t\t\t\talert(errors)\n\t\t       \treturn false;\t\n\t\t\t   }\n\t\t\t\t//loginpwdlen=10\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\tif ( new_password1.length >20) {\n\t\t\t\terrors=getMessage(\'PWD_MAX_20_CHAR\',\'SM\');\n\t\t       alert(errors)\n\t\t       \treturn false;\t\n\t\t\t   }\n\t\t\t}\n\t\t/*if ( new_password1.length > 10 ) {\n\t\t\n\t\t\terrors=getMessage(\'MAX_LENGTH_10_CH\');\n\t\talert(errors)\n\t\t\treturn false;\t\t}*/\n\t\tif(changepwdfor!=\'P\')\n\t\t\t\t{\n\t\t\t\tif(changepwdfor==\'L\')\t\n\t\t\t\t{\n\t\t\t\t//Maheshwaran K commeneted this lines for BSP-SCF-0107 as on 28-04-2022\n\t\t\t\t/*\tif ( current_password.length < password_length_min ) {\n\t\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\t\talert(errors)\n\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t*/\n\t\t\t\t}\n\t\t\telse\n\t\t\t\t{\t\n\t\t\t\tif( current_password.length < 5 ) {\n\t\t\t\terrors=getMessage(\'MIN_LENGTH_5_CH\',\'SM\');\n\t\t\t\talert(errors)\n\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t}\n\t\t if(changepwdfor==\'L\') \n\t\t{\n\t\tif ( current_password.length >\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' ) {\n\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\terrors=errors.replace(\"#\",\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\n\t\talert(errors)\n\t\treturn false;\n\t\t}\n\t\t  \t\t}else\n\t\t\t{\n\t\t\tif ( current_password.length >20 ) {\n\t\t\t\n\t\t\terrors=getMessage(\'MAX_LENGTH_10_CH\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false;\n\t\t  }\n\t\t\t}\n\t\t\n\t\tif(changepwdfor==\'L\') \n\t\t\t{\n\t\t\tif(case_sensitive_password_yn==\'N\')\n\t\t\t\t{\n\t\t\t\tif ( current_password.toUpperCase() == new_password1.toUpperCase() || current_password.toUpperCase() == new_password2.toUpperCase() ) \n\t\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'OLD_NEW_PW_SAME\',\'SM\');\n\t\t\t\t\talert(errors)\n\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\telse\n\t\t\t\t{\n\t\t\t\tif (current_password == new_password1 || current_password == new_password2) \n\t\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'OLD_NEW_PW_SAME\',\'SM\');\n\t\t\t\t\talert(errors)\n\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\telse\n\t\t\t{\n\t\t\tif ( current_password.toUpperCase() == new_password1.toUpperCase() || current_password.toUpperCase() == new_password2.toUpperCase() ) \n\t\t\t\t{\n\t\t\t\terrors = getMessage(\'OLD_NEW_PW_SAME\',\'SM\');\n\t\t\t\talert(errors)\n\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\tif ( result )\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' == \'N\')\n\t\t\t{\n\t\t\t\tvar html = \"<html><body onKeyDown = \'lockKey()\'><form name=\'dummyForSubmit\' id=\'dummyForSubmit\'  action=\'../../servlet/eSM.ChangePasswordServlet\' method=\'post\'>\";\n\t\t\t\tfor(var i=0;i<document.change_password_form.elements.length;i++)\n\t\t\t\t{\n\t\t\t\t\tvar n = document.change_password_form.elements(i).name;\n\t\t\t\t\tvar v = document.change_password_form.elements(i).value;\n\t\t\t\t\thtml += \"<input type=hidden name=\"+n+\" id=\"+n+\" value=\"+v+\">\";\n\t\t\t\t}\n\t\t\t\thtml+=\"</form></body></html>\";\n\t\t\t\tparent.frames[1].document.body.insertAdjacentHTML(\"AfterBegin\",html);\n\t\t\t\tparent.frames[1].document.dummyForSubmit.submit();\n\t\t\t}\n\t\t\telse\n\t\t\t\t{\n\t\t\t\tdocument.change_password_form.submit() ;\n\t\t\t\t}\n\t\t}\n\t\t\n\t}\n\t\t\n\n\t}\n\tfunction cancelClose()\n\t{\n\t\t//parent.window.close();\n\t\t//parent.window.returnValue = \'F\';\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = \'F\';\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n        dialogTag.close();\n\t}\t\t\n\t\t\n</script>\n\t</form>\n</center>\n</body>\n\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

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
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String mainyn = request.getParameter("main")==null?"":request.getParameter("main");

            _bw.write(_wl_block9Bytes, _wl_block9);

	String current_user	 = (String) session.getAttribute( "login_user" ) ;
	String facility_id	 = (String) session.getAttribute( "facility_id" ) ;
	String locale	=	(String)session.getAttribute("LOCALE");

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2 
	String login_user_type = (String)session.getAttribute("login_user_type")==null?"":(String)session.getAttribute("login_user_type");

	String current_password	 = "" ;
	String pinpwd="";
    String disppas="";
    String senpass="";
    String hrpass="";
	String ph_install_yn = "";
	int senCnt=0;
	int mrCnt=0;
	int phCnt=0;
	Connection con =null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	//Maheshwaran added for the MMS-QH-CRF-0149
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	int PASSWORD_LENGTH_MIN=0;
	int PASSWORD_LENGTH_MAX=0;
	//End
	String RESP_GROUP_ID = "";
	//end
	try{
	con = ConnectionManager.getConnection(request);

	pstmt							= con.prepareStatement("select install_yn from sm_module where module_id='PH' ");
	rs								= pstmt.executeQuery();
	while(rs!=null  && rs.next())
	{
				ph_install_yn		= rs.getString(1);
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		if(rs!=null)rs.close();
		pstmt	 = con.prepareStatement("select ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param");
		rs=pstmt.executeQuery();
		if(rs.next())
			{
			ENFORCE_PASSWORD_POLICY_YN=rs.getString("ENFORCE_PASSWORD_POLICY_YN");
			CASE_SENSITIVE_PASSWORD_YN=rs.getString("CASE_SENSITIVE_PASSWORD_YN");
			ALLOWED_SPL_CHAR_IN_PASSWORD=rs.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
			PASSWORD_LENGTH_MIN=rs.getInt("PASSWORD_LENGTH_MIN");
			PASSWORD_LENGTH_MAX=rs.getInt("PASSWORD_LENGTH_MAX");
			}
		if(pstmt!=null)pstmt.close();	
		if(rs!=null)rs.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
	//"ORA_RSRC_GROUP_ID" was added in the query by Maheshwaran K for the Password Validation as on 11/07/212
	//pstmt	 = con.prepareStatement( "select UPPER(app_password.decrypt( appl_user_password )) as password ,UPPER(app_password.decrypt(pin_no)) as pinpwd,ORA_RSRC_GROUP_ID  from sm_appl_user where appl_user_id = ?" ) ;
	try{
	pstmt	 = con.prepareStatement( "select app_password.decrypt( appl_user_password ) as password ,UPPER(app_password.decrypt(pin_no)) as pinpwd,ORA_RSRC_GROUP_ID  from sm_appl_user where appl_user_id = ?" ) ;
	pstmt.setString( 1, current_user ) ;
	rs = pstmt.executeQuery() ;
	
	if ( rs != null && rs.next() )
		{
		current_password = rs.getString( "password" ) ==null?"":rs.getString( "password" );
		pinpwd = rs.getString( "pinpwd" )==null?"":rs.getString( "pinpwd" );
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		RESP_GROUP_ID = rs.getString( "ORA_RSRC_GROUP_ID" )==null?"":rs.getString( "ORA_RSRC_GROUP_ID" );
		//End
		}
	if(CASE_SENSITIVE_PASSWORD_YN.equals("N"))	
		{
		current_password=current_password.toUpperCase();
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
   }
   catch(Exception e)
	{}
	
	pstmt	 = con.prepareStatement("SELECT COUNT(*) senCnt FROM MR_USER_ACCESS_RIGHTS WHERE FACILITY_ID=?  and  APPL_USER_ID=? and SEN_DIAG_PASSWORD IS NOT NULL") ;
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	rs = pstmt.executeQuery() ;
	rs.next();
	senCnt = rs.getInt( "senCnt" ) ;
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(senCnt>0)
	{
	pstmt	 = con.prepareStatement("select  UPPER(APP_PASSWORD.DECRYPT(SEN_DIAG_PASSWORD)) as senpass  from MR_USER_ACCESS_RIGHTS where FACILITY_ID=? AND APPL_USER_ID=?");
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	rs = pstmt.executeQuery() ;
	if ( rs != null && rs.next() )
	senpass = rs.getString("senpass" )==null?"":rs.getString( "senpass" ) ;
	
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();


    pstmt	 = con.prepareStatement("SELECT COUNT(*) mrCnt FROM MR_USER_ACCESS_RIGHTS WHERE FACILITY_ID=?  and APPL_USER_ID=? and HIGH_RISK_PASSWORD IS NOT NULL") ;
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	rs = pstmt.executeQuery() ;
	rs.next();
	mrCnt = rs.getInt("mrCnt") ;
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

   if(mrCnt>0)
	{
    pstmt	 = con.prepareStatement("select   UPPER(APP_PASSWORD.DECRYPT(HIGH_RISK_PASSWORD)) as hrpass  from MR_USER_ACCESS_RIGHTS where FACILITY_ID=? AND APPL_USER_ID=?");
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	 rs = pstmt.executeQuery() ;
	
	if ( rs != null && rs.next() )
	hrpass=  rs.getString( "hrpass" )==null?"": rs.getString( "hrpass" );
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	}
    if (ph_install_yn.equals("Y"))
	{
		pstmt	 = con.prepareStatement("select count(*) phCnt from PH_DISP_USERS WHERE   APPL_USER_ID=? ") ;
		pstmt.setString( 1, current_user ) ;
		rs = pstmt.executeQuery() ;
		rs.next();
		phCnt = rs.getInt("phCnt") ;
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(phCnt>0)
		{
		
		 pstmt	 = con.prepareStatement( "select  UPPER(APP_PASSWORD.DECRYPT(DISP_PASSWORD)) as disppas from PH_DISP_USERS where APPL_USER_ID=?" ) ;
		 pstmt.setString( 1, current_user ) ;
		 rs = pstmt.executeQuery() ;
		 if ( rs != null && rs.next() )
		 disppas = rs.getString( "disppas" )==null?"":rs.getString( "disppas" ) ;
		 if(rs!=null) rs.close();
		 if(pstmt!=null) pstmt.close();
			
		}
	}
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( java.net.URLDecoder.decode(((String) session.getAttribute( "facility_name" )==null?"":(String) session.getAttribute( "facility_name" )))  ));
            _bw.write(_wl_block11Bytes, _wl_block11);

						java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
						out.println(DateUtils.convertDate(dateformat.format( new java.util.Date()),"DMY","en",locale)) ;
					
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( current_user ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(!login_user_type.equals("AD")){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(senCnt>0)
		    {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mrCnt>0)
		    {
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(phCnt>0)
		    {
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ALLOWED_SPL_CHAR_IN_PASSWORD));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( current_password));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mainyn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(senpass));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hrpass));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(pinpwd));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disppas));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(phCnt));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(mrCnt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(senCnt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ph_install_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(CASE_SENSITIVE_PASSWORD_YN));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(RESP_GROUP_ID));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mainyn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(mainyn));
            _bw.write(_wl_block65Bytes, _wl_block65);
 }catch(Exception e){out.println("Error "+e);}
	finally {
		if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.changePasswordFor.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.login.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SensitiveDiagnosis.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighRiskConditions.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensing.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oldPassword.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.newPassword.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reEnterNewPassword.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PASSWORD_POLICY.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PASSWORD_POLICY1.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
