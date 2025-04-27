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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __change_password_form_login extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/change_password_form_login.jsp", 1719395001088L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n<head>\n  <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\">      ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"JavaScript\">\nfunction CheckOneSpecialChar(obj,enforce_password_policy_yn,allowed_spl_char_in_password)\n{\n\tvar fieldval = obj.value;\n\tvar fieldlen = fieldval.length;\n\tvar to_check = true;\n\tvar SpChar = new Array();\n\tvar allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\tallowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace(\"+\",\'\');\n\t//Maheshwaran added for the MMS-QH-CRF-0149\n\tif(enforce_password_policy_yn==\'Y\')\n\t\t{\n\t\tSpChar[0] = \'!\';\n\t\tSpChar[1] = \'#\';\n\t\tSpChar[2] = \'%\';\n\t\tSpChar[3] = \'&\';\n\t\tSpChar[4] = \'(\';\n\t\tSpChar[5] = \')\';\n\t\tSpChar[6] = \'+\';\n\t\tSpChar[7] = \'=\';\n\t\tSpChar[8] = \'|\';\n\t\tSpChar[9] = \'\\\\\';\n\t\tSpChar[10] = \'{\';\n\t\tSpChar[11] = \'}\';\n\t\tSpChar[12] = \':\';\n\t\tSpChar[13] = \';\';\n\t\tSpChar[14] = \'\"\';\n\t\tSpChar[15] = \'<\';\n\t\tSpChar[16] = \'>\';\n\t\tSpChar[17] = \'/\';\n\t\tSpChar[18] = \'\\\'\';\n\t\tSpChar[19] = \'\';\n\t\tSpChar[20] = \',\';\n\t\tSpChar[21] = \'.\';\n\t\tSpChar[22] = \'@\';\n\t\t}\n\telse{\n\t\tSpChar[0] = \'~\';\n\t\tSpChar[1] = \'`\';\n\t\tSpChar[2] = \'!\';\n\t\tSpChar[3] = \'@\';\n\t\tSpChar[4] = \'#\';\n\t\tSpChar[5] = \'$\';\n\t\tSpChar[6] = \'%\';\n\t\tSpChar[7] = \'^\';\n\t\tSpChar[8] = \'&\';\n\t\tSpChar[9] = \'*\';\n\t\tSpChar[10] = \'(\';\n\t\tSpChar[11] = \')\';\n\t\tSpChar[12] = \'-\';\n\t\tSpChar[13] = \'+\';\n\t\tSpChar[14] = \'=\';\n\t\tSpChar[15] = \'|\';\n\t\tSpChar[16] = \'\\\\\';\n\t\tSpChar[17] = \'[\';\n\t\tSpChar[18] = \']\';\n\t\tSpChar[19] = \'{\';\n\t\tSpChar[20] = \'}\';\n\t\tSpChar[21] = \':\';\n\t\tSpChar[22] = \';\';\n\t\tSpChar[23] = \'\"\';\n\t\tSpChar[24] = \'<\';\n\t\tSpChar[25] = \'>\';\n\t\tSpChar[26] = \'?\';\n\t\tSpChar[27] = \'/\';\n\t\tSpChar[28] = \'\\\'\';\n\t\tSpChar[29] = \'\';\n\t\tSpChar[30] = \',\';\n\t\tSpChar[31] = \'.\';\n\t\t}\n\t\tif (fieldval.substr(0,1) == \'_\' ) \n\t{\n\t\tto_check = false;\n\t}\n\n\tfor (var i=0;i<fieldlen;i++)\n\t{\n\n\t\tif (fieldval.substr(i,1) == \' \' || fieldval.substr(i,1) == null)\n\t\t{\n\t\t\tto_check = false;\n\t\t}\n\t\t//Maheshwaran added for the MMS-QH-CRF-0149\n\t\tif(enforce_password_policy_yn==\'Y\')\n\t\t\t{\n\t\t\tfor (var j=0;j<=22;j++)\n\t\t\t\t{\n\t\t\t\tif (fieldval.substr(i,j) == SpChar[j])\n\t\t\t\t\t{\n\t\t\t\t\tto_check = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\t\t\n\t\telse\n\t\t\t{\n\t\t\tfor (var j=0;j<=31;j++)\n\t\t\t\t{\n\t\t\t\tif (fieldval.substr(i,j) == SpChar[j])\n\t\t\t\t\t{\n\t\t\t\t\tto_check = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t}\n\t\t\n\t\n\tif (to_check == false)\n\t{\t\n\t\t//Maheshwaran added for the MMS-QH-CRF-0149\n\t\tif(enforce_password_policy_yn==\'Y\'){\n\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password1));\n\t\t}\n\t\telse\n\t\t\t{\n\t\t\talert(getMessage(\'SPECIAL_CHARCTERS_NOT_ALLOWED\',\'SM\'));\n\t\t\t}\n\t\tobj.select();\n\t\tobj.focus();\n\t\tobj.value=\'\';\n\t}\n\n\t}\n\n\t\n\tfunction checkLen_1(Obj,enforce_password_policy_yn,allowed_spl_char_in_password,password_length_min,password_length_max) {\n\t\t\tvar errors = \"\" ;\n\t\t\tvar len_one=Obj.value.length;\n\t\t\t\tvar allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\t\tallowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace(\"+\",\'\')\n\t\t\tif (len_one <password_length_min)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\t\t\talert(errors);\n\t\t\t\t\tObj.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (len_one >password_length_max)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\t\t\terrors=errors.replace(\"#\",password_length_max);\n\t\t\t\t\talert(errors);\n\t\t\t\t\tObj.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\t\t\t\n\t\t\t\telse {\n\t\t\t\tif(enforce_password_policy_yn==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\tChkPWSplChar(Obj,allowed_spl_char_in_password1);\n\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\nfunction checkLen_2(len,enforce_password_policy_yn,allowed_spl_char_in_password,password_length_min,password_length_max){\n\n\t\t\tvar errors = \"\" ;\n\t\t\tvar len_two=len.value.length;\n\t\t\t\tvar allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\t\tallowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace(\"+\",\'\')\n\t\t\tif (len_two <password_length_min)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\t\t\talert(errors);\n\t\t\t\t\tlen.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (len_two >password_length_max)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\t\t\terrors=errors.replace(\"#\",password_length_max);\n\t\t\t\t\talert(errors);\n\t\t\t\t\tlen.focus();\n\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\n\t\t\t\tif(enforce_password_policy_yn==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\tChkPWSplChar(len,allowed_spl_char_in_password1);\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\n\tfunction checkPassword() {\n\t\tvar current_password\t= change_password_form.current_password.value ;\n\n\t\tvar old_password\t\t= change_password_form.old_password.value ;\n\n\t\tvar new_password1\t\t= change_password_form.new_password1.value ;\n\n\t\tvar new_password2\t\t= change_password_form.new_password2.value ;\n\t\tvar password_length_min\t\t= change_password_form.password_length_min.value ;\n\t\tvar password_length_max\t\t= change_password_form.password_length_max.value ;\n\t\tvar case_sensitive_password_yn\t\t= change_password_form.case_sensitive_password_yn.value ;\n\t\t\n\n\t\tvar errors\t\t\t= \"\" ;\n\t\tvar result\t\t\t= true ;\n\t\t//Maheshwaran added for the MMS-QH-CRF-0149 \n\t\tif(case_sensitive_password_yn==\'N\')\n\t\t\t{\n\t\t\told_password=old_password.toUpperCase();\n\t\t\tcurrent_password=current_password.toUpperCase();\n\t\t\t}\n\n\t\tif ( current_password != old_password ) {\n           \n\t\t\terrors=getMessage(\'INCORRECT_OLD_PW\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false ;\n\t\t}\n\n\t\tif ( new_password1 != new_password2 ) {\n\t\t\t\n\t\t\terrors=getMessage(\'CONF_PASS_NOT_SAME_AS_NEW_PASS\',\'SM\');\n\t\t    alert(errors)\n\t\t\treturn false ;\n\t\t}\n\n\t\tif ( new_password1.length < password_length_min ) {\n\t\t\t\n\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\talert(errors)\n\t\t\treturn false ;\n\t\t}\n\t\tif ( new_password1.length > password_length_max ) {\n\t\t\t\n\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\terrors=errors.replace(\"#\",password_length_max);\n\t\t\talert(errors)\n\t\t\treturn false ;\n\t\t}\n\t\tif ( current_password.length < password_length_min ) {\n\t\t\t\n\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\talert(errors)\n\t\t\treturn false ;\n\t\t}\n\t\tif ( current_password.length > password_length_max ) {\n\t\t\t\n\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\terrors=errors.replace(\"#\",password_length_max);\n\t\t\talert(errors)\n\t\t\treturn false ;\n\t\t}\n\n\t\tif ( current_password == new_password1 || current_password == new_password2 ) {\n\t\t\t\n\t\t\terrors = getMessage(\'OLD_NEW_PW_SAME\',\'SM\');\n\t\t\talert(errors)\n\t\t\treturn false ;\n\t\t}\n\n\t\t//if ( result )\n\t\t//{\t\t\t\n\t\t\t\t\n\t\t\t\tdocument.change_password_form.submit() ;\n\t\t//}\n\t\t//else\n\t\t//\talert( errors ) ;\n\n\t\t//return result ;\n\t}\n\n\n\tfunction cancelClose()\n\t{\n\t\t//parent.window.close();\n\t\t//parent.window.returnValue = \'F\';\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = \'F\';\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n        dialogTag.close();\n\t}\n\t//Maheshwaran added for the MMS-QH-CRF-0149\nfunction ChkPWSplChar(obj,allowed_spl_char_in_password)\n\t{\n\tvar value = obj.value;\n\tallowed_spl_char_in_password=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\tallowed_spl_char_in_password = allowed_spl_char_in_password.replace(\"+\",\'\')\n\tvar paswd1=/^[a-zA-Z](?=.*[0-9])/;\n\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\tstrCheck= strCheck.concat(allowed_spl_char_in_password);\n\tvar strCheck1 = \'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\tvar paswd4=/^[a-zA-Z]*$/;\n\tif(obj.value.match(paswd1))\n\t\t{\n\t\tfor (var i = 0; i < value.length; i++) \n\t\t\t{\n\t\t\tif (strCheck.indexOf(value.charAt(i)) == -1) \n\t\t\t\t{\n\t\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\t\tobj.value=\"\";\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t}\n\t\t}\n\telse if(value.match(paswd4))\n\t\t{\n\t\tif (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) \n\t\t\t{\n\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\tobj.value=\"\";\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\telse\n\t\t{\n\t\tfor (var i = 0; i < value.length; i++) \n\t\t\t{\n\t\t\tif (strCheck1.indexOf(value.charAt(i)) == -1) \n\t\t\t\t{\n\t\t\t\tif (allowed_spl_char_in_password.indexOf(value.charAt(i)) != -1) \n\t\t\t\t\t{\n\t\t\t\t\tif(value.indexOf(value.charAt(i))==0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\tif (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) \n\t\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'PASSWORD_POLICY\',\'SM\').concat(\" \"+allowed_spl_char_in_password));\n\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\tobj.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t}\n\t}\t\nfunction CheckForNumber(obj) \n{\n\tif (obj.value.length > 0 )\n\t{\n\t\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)\n\t\t{\t\t\n\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\tobj.value=\'\';\n\t\t\tobj.select();\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\n\t\tif (obj.value.substr(0,1) >= 0)\n\t\t{\n\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\tobj.value=\'\';\n\t\t\tobj.select();\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n</script>\n\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<body class=\"CONTENT\"  OnMouseDown=\'CodeArrest()\' ; onKeyDown = \'lockKey()\';  onLoad=\"window.document.title=\'Change Password\';\">\n<center>\n\n\t<table width=\"100%\">\n\t\t<tr class=\"HEADER\">\n\t\t\t<td class=\"HEADER\" valign=\"top\" width=\"10%\">\n\t\t\t\t<img src=\"../../eCommon/images/orgLogo.gif\" vspace=0 hspace=0>\n\t\t\t</td>\n\n\t\t\t<td class=\"HEADER\" valign=\"top\" width=\"65%\">\n\t\t\t\n\t\t\t</td>\n\n\t\t\t<td class=\"HEADER\" valign=\"top\" width=\"15%\">\n\t\t\t\t<font size=\"-1\">\n\t\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t</b>\n\t\t\t\t</font>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t<h3>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</h3>\n\n\t<form name=\"change_password_form\" id=\"change_password_form\" method=\"post\" action=\"../../servlet/eSM.ChangePasswordServletLogin\">\n\t\t<table width=\"90%\" cellpadding=\'0\' cellspacing=\'0\'>\n\t\t\t<tr><td colspan=\'2\'>&nbsp;</td></tr>\n\n\t\t\t<tr>\n\t\t\t\t<td width=\'50%\' class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"user\" id=\"user\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" readonly>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"password\" name=\"old_password\" id=\"old_password\" maxlength=10>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"password\" name=\"new_password1\" id=\"new_password1\" maxlength=\"10\" onChange=\"checkLen_1(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =");\" onkeypress=\'checkMaxLimit(this,10)\' onBlur=\"\" onKeyUp=\"CheckOneSpecialChar(this,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');CheckForNumber(this)\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</td>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t\t<input type=\"password\" name=\"new_password2\" id=\"new_password2\" maxlength=\"10\" onBlur=\"\" onChange=\"checkLen_2(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =");\" onkeypress=\'checkMaxLimit(this,10)\' onKeyUp=\"CheckOneSpecialChar(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');CheckForNumber(this)\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=\'2\'>&nbsp;</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<tr>\n\t\t\t <td colspan=\'3\' class=\'label\' style=\'color:red\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b>&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</table>\n\n\t\t<br>\n\n\t\t<input type=\"hidden\" name=\"current_password\" id=\"current_password\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\"hidden\" name=\"current_user\" id=\"current_user\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\"hidden\" name=\"startup_db_driver\" id=\"startup_db_driver\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\"hidden\" name=\"startup_connect_string\" id=\"startup_connect_string\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\"hidden\" name=\"startup_user\" id=\"startup_user\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\"hidden\" name=\"startup_password\" id=\"startup_password\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onClick=\'checkPassword();\'> &nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onClick=\"cancelClose();\">\n\t\t<input type=\'hidden\' name=\'allowed_spl_char_in_password\' id=\'allowed_spl_char_in_password\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=\'hidden\' name=\'enforce_password_policy_yn\' id=\'enforce_password_policy_yn\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=\'hidden\' name=\'case_sensitive_password_yn\' id=\'case_sensitive_password_yn\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\t\n\t\t<input type=\'hidden\' name=\'password_length_min\' id=\'password_length_min\' value=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =">\t\n\t\t<input type=\'hidden\' name=\'password_length_max\' id=\'password_length_max\' value=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">\t\n\n\t</form>\n</center>\n</body>\n\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

  
	
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);

    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String current_user=request.getParameter("ecis_jdbc_user");
	String startup_db_driver=request.getParameter("startup_db_driver");
	String startup_connect_string=request.getParameter("startup_connect_string");
	String startup_user=request.getParameter("startup_user");
	String startup_password=request.getParameter("startup_password");
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	//Maheshwaran added for the MMS-QH-CRF-0149
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	int PASSWORD_LENGTH_MIN=0;
	int PASSWORD_LENGTH_MAX=0;
	//End
	String current_password	 = "" ;
	Connection con						=null;
	ResultSet rs1=null;
	PreparedStatement pstmt = null;
	try
		{
	Class.forName( startup_db_driver ) ;
	con = DriverManager.getConnection( startup_connect_string, startup_user, startup_password ) ;
	//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		if(rs1!=null)rs1.close();
		pstmt	 = con.prepareStatement("select ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param");
		rs1=pstmt.executeQuery();
		if(rs1.next())
			{
			ENFORCE_PASSWORD_POLICY_YN=rs1.getString("ENFORCE_PASSWORD_POLICY_YN");
			CASE_SENSITIVE_PASSWORD_YN=rs1.getString("CASE_SENSITIVE_PASSWORD_YN");
			ALLOWED_SPL_CHAR_IN_PASSWORD=rs1.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
			PASSWORD_LENGTH_MIN=rs1.getInt("PASSWORD_LENGTH_MIN");
			PASSWORD_LENGTH_MAX=rs1.getInt("PASSWORD_LENGTH_MAX");
			}
		if(pstmt!=null)pstmt.close();	
		if(rs1!=null)rs1.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
	if(pstmt!=null)pstmt.close();		
	pstmt	 = con.prepareStatement( "select app_password.decrypt( appl_user_password ) as password from sm_appl_user where appl_user_id = ?" ) ;	
	pstmt.setString( 1, current_user ) ;
	ResultSet rs = pstmt.executeQuery() ;
	if ( rs != null && rs.next() )
	current_password = rs.getString( "password" ) ;
	if(CASE_SENSITIVE_PASSWORD_YN.equals("N"))	
		{
		current_password=current_password.toUpperCase();
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	

            _bw.write(_wl_block7Bytes, _wl_block7);

						java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
						out.println( dateformat.format( new java.util.Date() ) ) ;
					
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( current_user ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")) {
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ALLOWED_SPL_CHAR_IN_PASSWORD));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( current_password ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( current_user ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( startup_db_driver ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( startup_connect_string ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( startup_user ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( startup_password ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CASE_SENSITIVE_PASSWORD_YN));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block39Bytes, _wl_block39);
 }
	catch(Exception e){out.println("Error "+e);}
	finally {
		if(pstmt!=null) pstmt.close();
	if(con != null) con.close();
	

	}
	
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.changepassword.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oldPassword.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.newPassword.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ReenterNewPassword.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PASSWORD_POLICY.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PASSWORD_POLICY1.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
